package com.realtime.blog_api.dto

data class CommentDto (
    val id: Int,
    var content: String,
    var post: PostDto?,
    var user: UserDto?
)