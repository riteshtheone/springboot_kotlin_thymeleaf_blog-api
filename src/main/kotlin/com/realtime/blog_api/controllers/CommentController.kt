package com.realtime.blog_api.controllers

import com.realtime.blog_api.dto.CommentDto
import com.realtime.blog_api.payloads.ApiResponse
import com.realtime.blog_api.services.CommentService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CommentController(@Autowired private val commentService: CommentService) {

    @PostMapping("/post/{postId}/comment")
    fun createComment(@RequestBody commentDto: CommentDto, @PathVariable postId: Int): ResponseEntity<CommentDto> = ResponseEntity(this.commentService.createComment(commentDto, postId), HttpStatus.CREATED)

    @PutMapping("/comment/{commentId}")
    fun updateComment(@RequestBody commentDto: CommentDto, @PathVariable commentId:Int) : ResponseEntity<CommentDto> = ResponseEntity.ok(this.commentService.updateComment(commentDto, commentId))

    @DeleteMapping("/comment/{commentId}")
    fun deleteComment(@PathVariable commentId: Int): ResponseEntity<ApiResponse> {
        this.commentService.deleteComment(commentId)
        return ResponseEntity(ApiResponse("Comment deleted successfully", true), HttpStatus.OK)
    }
    @GetMapping("/comment/{commentId}")
    fun getComment(@PathVariable commentId: Int): ResponseEntity<CommentDto> = ResponseEntity(this.commentService.getCommentById(commentId), HttpStatus.OK)

    @GetMapping("/user/{userId}/comment")
    fun getCommentByUser(@PathVariable userId: Int): ResponseEntity<List<CommentDto>> = ResponseEntity(this.commentService.getCommentByUser(userId), HttpStatus.OK)

    @GetMapping("/post/{postId}/comment")
    fun getCommentByPost(@PathVariable postId: Int): ResponseEntity<List<CommentDto>> = ResponseEntity(this.commentService.getCommentByPost(postId), HttpStatus.OK)

    @GetMapping("/comment/all")
    fun getAllComment(): ResponseEntity<List<CommentDto>> = ResponseEntity(this.commentService.getAllComment(), HttpStatus.OK)
}