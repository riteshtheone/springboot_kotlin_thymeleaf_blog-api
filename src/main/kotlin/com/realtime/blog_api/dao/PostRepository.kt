//package com.realtime.blog_api.dao
//
//import com.realtime.blog_api.entities.Category
//import com.realtime.blog_api.entities.Post
//import com.realtime.blog_api.entities.User
//import org.springframework.data.jpa.repository.JpaRepository
//
//interface PostRepository : JpaRepository<Post, Int> {
//    fun findByUser(user: User): List<Post>
//    fun findByCategory(category: Category): List<Post>
//}