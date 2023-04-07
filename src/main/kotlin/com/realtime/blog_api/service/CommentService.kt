package com.realtime.blog_api.service

import com.realtime.blog_api.dto.CommentDto

interface CommentService {
    //  create
    fun createComment(commentDto: CommentDto, postId: Int, userId: Int): CommentDto

    //  update
    fun updateComment(commentDto: CommentDto, commentId: Int): CommentDto

    //  get
    fun getCommentById(commentId: Int): CommentDto

    //  get all
    fun getAllComment(): List<CommentDto>

    //  delete
    fun deleteComment(commentId: Int)

    //  get all comments by post
    fun getCommentByPost(postId: Int): List<CommentDto>

    //  get all posts by user
    fun getCommentByUser(userId: Int): List<CommentDto>
}