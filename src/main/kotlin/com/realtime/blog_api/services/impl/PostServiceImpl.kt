//package com.realtime.blog_api.services.impl
//
//import com.realtime.blog_api.beans.CategoryBean
//import com.realtime.blog_api.beans.PostBean
//import com.realtime.blog_api.beans.UserBean
//import com.realtime.blog_api.dao.CategoryRepository
//import com.realtime.blog_api.dao.PostRepository
//import com.realtime.blog_api.dao.UserRepository
//import com.realtime.blog_api.entities.Category
//import com.realtime.blog_api.entities.Post
//import com.realtime.blog_api.entities.User
//import com.realtime.blog_api.exceptions.ResourceNotFoundException
//import com.realtime.blog_api.services.PostService
//import org.modelmapper.ModelMapper
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//import java.util.Date
//
//@Service
//class PostServiceImpl(
//    @Autowired private val postRepository: PostRepository,
//    @Autowired private val modelMapper: ModelMapper,
//    @Autowired private val userRepository: UserRepository,
//    @Autowired private val categoryRepository: CategoryRepository) : PostService {
//
//    override fun createPost(postBean: PostBean, userId: Int, categoryId: Int): Post {
//        val user: User = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) }
//        println("here 1")
//        val category: Category = this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) }
//        println("here 2")
//        postBean.image = "default.png"
//        println("here 3")
//        postBean.postDate = Date()
//        println("here 4")
//        postBean.user = user
//        println("here 5")
//        postBean.category = category
//        println("here 6")
//        val post: Post = this.modelMapper.map(postBean, Post::class.java)
//        println("here 7")
//        val savedPost: Post = this.postRepository.save(post)
//        println("here 8")
//        println(savedPost.toString())
//        val postBean2: PostBean = this.modelMapper.map(savedPost, PostBean::class.java)
//        println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
//        return savedPost
//    }
//
//    override fun updatePost(postBean: PostBean, postId: Int): PostBean {
//        TODO("Not yet implemented")
//    }
//
//    override fun getPostById(postId: Int): PostBean {
//        TODO("Not yet implemented")
//    }
//
//    override fun getAllPosts(): List<PostBean> {
//        TODO("Not yet implemented")
//    }
//
//    override fun deletePost(postId: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getPostByCategoryId(categoryId: Int): List<PostBean> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getPostByUserId(userId: Int): List<PostBean> {
//        TODO("Not yet implemented")
//    }
//
//    override fun searchPosts(keyword: String): List<PostBean> {
//        TODO("Not yet implemented")
//    }
//
//}