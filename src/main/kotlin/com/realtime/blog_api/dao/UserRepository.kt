package com.realtime.blog_api.dao

import com.realtime.blog_api.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>
