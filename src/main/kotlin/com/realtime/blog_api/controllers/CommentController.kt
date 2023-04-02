package com.realtime.blog_api.controllers

import com.realtime.blog_api.beans.CommentBean
import com.realtime.blog_api.payloads.ApiResponse
import com.realtime.blog_api.services.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CommentController(@Autowired private val commentService: CommentService) {

    @PostMapping("/post/{postId}/comment")
    fun createComment(@RequestBody commentBean: CommentBean, @PathVariable postId: Int): ResponseEntity<CommentBean> = ResponseEntity<CommentBean>(this.commentService.createComment(commentBean, postId), HttpStatus.CREATED)

    @DeleteMapping("/comment/{commentId}")
    fun deleteComment(@PathVariable commentId: Int): ResponseEntity<ApiResponse> {
        this.commentService.deleteComment(commentId)
        return ResponseEntity<ApiResponse>(ApiResponse("Comment deleted successfully", true), HttpStatus.OK)
    }
}