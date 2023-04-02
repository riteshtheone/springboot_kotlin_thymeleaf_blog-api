package com.realtime.blog_api.payloads

import com.realtime.blog_api.beans.PostBean

class PostResponse {
    var content: List<PostBean> = ArrayList()
    var pageNumber: Int = 0
    var pageSize: Int = 0
    var totalElements: Long = 0
    var totalPages: Int = 0
    var lastPage: Boolean = false
}