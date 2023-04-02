package com.realtime.blog_api.dao

import com.realtime.blog_api.entities.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Int>