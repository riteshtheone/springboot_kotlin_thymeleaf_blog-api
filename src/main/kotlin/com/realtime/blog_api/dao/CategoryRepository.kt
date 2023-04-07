package com.realtime.blog_api.dao

import com.realtime.blog_api.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int>
