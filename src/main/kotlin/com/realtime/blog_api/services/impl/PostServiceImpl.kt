package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.PostBean
import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entities.Post
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.services.PostService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date

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
        TODO("Not yet implemented")
    }

    override fun getPostById(postId: Int): PostBean {
        TODO("Not yet implemented")
    }

    override fun getAllPost(): List<PostBean> {
        TODO("Not yet implemented")
    }

    override fun deletePost(postId: Int) {
        TODO("Not yet implemented")
    }

    override fun getPostByCategory(categoryId: Int): List<PostBean> {
        TODO("Not yet implemented")
    }

    override fun getPostByUser(userId: Int): List<PostBean> {
        TODO("Not yet implemented")
    }

    override fun searchPosts(keyword: String): List<PostBean> {
        TODO("Not yet implemented")
    }

}