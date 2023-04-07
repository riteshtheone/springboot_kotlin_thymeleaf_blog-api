package com.realtime.blog_api.dto

import java.util.Date

data class PostDto (
     val id: Int,
     var title: String,
     var content: String,
     var image: String,
     var postDate: Date?,
     var category: CategoryDto?,
     var user: UserDto?
)