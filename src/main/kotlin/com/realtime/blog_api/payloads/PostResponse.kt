package com.realtime.blog_api.payloads

import com.realtime.blog_api.dto.PostDto

class PostResponse {
    var content: List<PostDto> = ArrayList()
    var pageNumber = 0
    var pageSize: Int = 0
    var totalElements: Long = 0
    var totalPages: Int = 0
    var lastPage: Boolean = false
}