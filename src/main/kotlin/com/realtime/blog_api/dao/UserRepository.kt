package com.realtime.blog_api.dao

import com.realtime.blog_api.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
}