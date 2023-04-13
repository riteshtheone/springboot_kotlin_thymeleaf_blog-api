package com.realtime.blog_api.service.impl

import com.realtime.blog_api.dto.PostDto
import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entity.Post
import com.realtime.blog_api.exception.ResourceNotFoundException
import com.realtime.blog_api.payload.PostResponse
import com.realtime.blog_api.service.PostService
import com.realtime.blog_api.utils.mapper.impl.PostMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import java.util.Date
import java.util.stream.Collectors

@Service
class PostServiceImpl(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val userRepository: UserRepository,
    @Autowired private val categoryRepository: CategoryRepository,
    @Autowired private val postMapper: PostMapper,
    ) : PostService {

    override fun createPost(postDto: PostDto, userId: Int, categoryId: Int): PostDto {
        val post: Post = this.postMapper.toEntity(postDto)
        post.image = "default.png"
        post.postDate = Date()
        post.user = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }
        post.category = this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "category id", categoryId) }
        return this.postMapper.toDomain(this.postRepository.save(post))
    }
    override fun updatePost(postDto: PostDto, postId: Int): PostDto {
        val post: Post = this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }
        post.title = postDto.title
        post.content = postDto.content
        post.image = postDto.image
        post.postDate = Date()
        return this.postMapper.toDomain(this.postRepository.save(post))
    }
    override fun getPostById(postId: Int): PostDto = this.postMapper.toDomain(this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) })
    override fun getAllPost(pageNumber: Int, pageSize: Int, sortBy: String, sortDir: String): PostResponse {
        val sort: Sort = if (sortDir.equals("descending", ignoreCase = true)) Sort.by(sortBy).descending() else Sort.by(sortBy).ascending()
        val pageable: Pageable = PageRequest.of(pageNumber, pageSize, sort)
        val pagePost: Page<Post> = this.postRepository.findAll(pageable)
        val postResponse = PostResponse()
        postResponse.content = pagePost.content.stream().map { post: Post -> this.postMapper.toDomain(post) }.collect(Collectors.toList())
        postResponse.pageNumber = pagePost.number
        postResponse.pageSize = pagePost.size
        postResponse.totalElements = pagePost.totalElements
        postResponse.totalPages = pagePost.totalPages
        postResponse.lastPage = pagePost.isLast
        return postResponse
    }
    override fun deletePost(postId: Int) = this.postRepository.delete(this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) })
    override fun getPostByCategory(categoryId: Int): List<PostDto> = this.postRepository.findByCategory(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "category id", categoryId) }).stream().map { post: Post -> this.postMapper.toDomain(post) }.collect(Collectors.toList())
    override fun getPostByUser(userId: Int): List<PostDto> = this.postRepository.findByUser(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }).stream().map { post: Post -> this.postMapper.toDomain(post) }.collect(Collectors.toList())
    override fun searchPosts(keyword: String): List<PostDto> = this.postRepository.findByTitleContaining(keyword).stream().map { post: Post -> this.postMapper.toDomain(post) }.collect(Collectors.toList())

}