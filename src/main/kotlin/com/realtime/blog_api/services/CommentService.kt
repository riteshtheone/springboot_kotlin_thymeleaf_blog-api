package com.realtime.blog_api.services

import com.realtime.blog_api.beans.CommentBean

interface CommentService {
    fun createComment(commentBean: CommentBean, postId: Int): CommentBean
    fun deleteComment(commendId: Int)
}