package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.PostBean
import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entities.Post
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.payloads.PostResponse
import com.realtime.blog_api.services.PostService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class PostServiceImpl(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val modelMapper: ModelMapper,
    @Autowired private val userRepository: UserRepository,
    @Autowired private val categoryRepository: CategoryRepository) : PostService {

    override fun createPost(postBean: PostBean, userId: Int, categoryId: Int): PostBean {
        val post: Post = this.modelMapper.map(postBean, Post::class.java)
        post.image = "default.png"
        post.postDate = Date()
        post.user = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }
        post.category = this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "category id", categoryId) }
        return this.modelMapper.map(this.postRepository.save(post), PostBean::class.java)
    }
    override fun updatePost(postBean: PostBean, postId: Int): PostBean {
        val post: Post = this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }
        post.title = postBean.title
        post.content = postBean.content
        post.image = postBean.image
        post.postDate = Date()
        return this.modelMapper.map(this.postRepository.save(post), PostBean::class.java)
    }
    override fun getPostById(postId: Int): PostBean = this.modelMapper.map(this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }, PostBean::class.java)
    override fun getAllPost(pageNumber: Int, pageSize: Int, sortBy: String, sortDir: String): PostResponse {
        val sort: Sort = if (sortDir.equals("descending", ignoreCase = true)) Sort.by(sortBy).descending() else Sort.by(sortBy).ascending()
        val pageable: Pageable = PageRequest.of(pageNumber, pageSize, sort)
        val pagePost: Page<Post> = this.postRepository.findAll(pageable)
        val postResponse = PostResponse()
        postResponse.content = pagePost.content.stream().map { post: Post -> this.modelMapper.map(post, PostBean::class.java) }.collect(Collectors.toList())
        postResponse.pageNumber = pagePost.number
        postResponse.pageSize = pagePost.size
        postResponse.totalElements = pagePost.totalElements
        postResponse.totalPages = pagePost.totalPages
        postResponse.lastPage = pagePost.isLast
        return postResponse
    }
    override fun deletePost(postId: Int) = this.postRepository.delete(this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) })
    override fun getPostByCategory(categoryId: Int): List<PostBean> = this.postRepository.findByCategory(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "category id", categoryId) }).stream().map { post: Post -> this.modelMapper.map(post, PostBean::class.java) }.collect(Collectors.toList())
    override fun getPostByUser(userId: Int): List<PostBean> = this.postRepository.findByUser(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }).stream().map { post: Post -> this.modelMapper.map(post, PostBean::class.java) }.collect(Collectors.toList())
    override fun searchPosts(keyword: String): List<PostBean> = this.postRepository.findByTitleContaining(keyword).stream().map { post: Post -> this.modelMapper.map(post, PostBean::class.java) }.collect(Collectors.toList())

}