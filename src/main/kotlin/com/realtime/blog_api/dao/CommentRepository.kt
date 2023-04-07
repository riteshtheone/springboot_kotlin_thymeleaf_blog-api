package com.realtime.blog_api.dao

import com.realtime.blog_api.entities.Comment
import com.realtime.blog_api.entities.Post
import com.realtime.blog_api.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Int> {
    fun findByUser(user: User): List<Comment>
    fun findByPost(post: Post): List<Comment>
}