package com.realtime.blog_api.service.impl

import com.realtime.blog_api.dto.CommentDto
import com.realtime.blog_api.dao.CommentRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.exception.ResourceNotFoundException
import com.realtime.blog_api.service.CommentService
import com.realtime.blog_api.utils.mapper.impl.CommentMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class CommentServiceImpl(
    @Autowired private val commentRepository: CommentRepository,
    @Autowired private val postRepository: PostRepository,
    @Autowired private val userRepository: UserRepository,
    @Autowired private val commentMapper: CommentMapper
    ): CommentService {

    override fun createComment(commentDto: CommentDto, postId: Int, userId: Int): CommentDto = this.commentMapper.toDomain(this.commentRepository.save(this.commentMapper.toEntity(commentDto).apply {
        this.post = postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }
        this.user = userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", postId) }
    }))
    override fun updateComment(commentDto: CommentDto, commentId: Int): CommentDto = this.commentMapper.toDomain(this.commentRepository.save(this.commentRepository.findById(commentId).orElseThrow { ResourceNotFoundException("Comment", "comment id", commentId) }.apply {
        this.comment = commentDto.comment
    }))
    override fun getCommentById(commentId: Int): CommentDto = this.commentMapper.toDomain(this.commentRepository.findById(commentId).orElseThrow { ResourceNotFoundException("Comment", "comment id", commentId) })
    override fun deleteComment(commentId: Int) = this.commentRepository.delete(this.commentRepository.findById(commentId).orElseThrow { ResourceNotFoundException("Comment", "comment id", commentId) })
    override fun getCommentByPost(postId: Int): List<CommentDto> = this.commentRepository.findByPost(this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }).stream().map { comment -> this.commentMapper.toDomain(comment) }.collect(Collectors.toList())
    override fun getCommentByUser(userId: Int): List<CommentDto> = this.commentRepository.findByUser(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "user id", userId) }).stream().map { comment -> this.commentMapper.toDomain(comment) }.collect(Collectors.toList())
    override fun getAllComment(): List<CommentDto> = this.commentRepository.findAll().stream().map { comment -> this.commentMapper.toDomain(comment) }.collect(Collectors.toList())
}