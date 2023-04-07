package com.realtime.blog_api.dao

import com.realtime.blog_api.entity.Category
import com.realtime.blog_api.entity.Post
import com.realtime.blog_api.entity.User

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Int> {
    fun findByUser(user: User): List<Post>
    fun findByCategory(category: Category): List<Post>
    fun findByTitleContaining(title: String): List<Post>
}