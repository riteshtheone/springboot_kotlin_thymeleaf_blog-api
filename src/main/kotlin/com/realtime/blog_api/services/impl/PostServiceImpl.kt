package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.PostBean
import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entities.Category
import com.realtime.blog_api.entities.Post
import com.realtime.blog_api.entities.User
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
        val user: User = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }
        val category: Category = this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "category id", categoryId) }
        val post: Post = this.modelMapper.map(postBean, Post::class.java)
        post.image = "default.png"
        post.postDate = Date()
        post.user = user
        post.category = category
        val savedPost: Post = this.postRepository.save(post)
        return this.modelMapper.map(savedPost, PostBean::class.java)









//        postBean.image = "default.png"
//        postBean.postDate = Date()
//        postBean.user = this.modelMapper.map(user, UserBean::class.java)
//        postBean.category = this.modelMapper.map(category, CategoryBean::class.java)
//        val post = Post()
//        post.title = postBean.title
//        post.content = postBean.content
//        post.image = postBean.image
//        post.postDate = postBean.postDate
//        post.user = this.modelMapper.map(postBean.user, User::class.java)
//        post.category = this.modelMapper.map(postBean.category, Category::class.java)
//        val newPost = this.postRepository.save(post)
//        return this.modelMapper.map(newPost, PostBean::class.java)
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