package com.realtime.blog_api.dao

import com.realtime.blog_api.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int>
