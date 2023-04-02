package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.CommentBean
import com.realtime.blog_api.dao.CommentRepository
import com.realtime.blog_api.dao.PostRepository
import com.realtime.blog_api.entities.Comment
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.services.CommentService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    @Autowired private val commentRepository: CommentRepository,
    @Autowired private val postRepository: PostRepository,
    @Autowired private val modelMapper: ModelMapper): CommentService {

    override fun createComment(commentBean: CommentBean, postId: Int): CommentBean {
        val post = this.postRepository.findById(postId).orElseThrow { ResourceNotFoundException("Post", "post id", postId) }
        val comment = this.modelMapper.map(commentBean, Comment::class.java)
        comment.post = post
        return this.modelMapper.map(this.commentRepository.save(comment), CommentBean::class.java)
    }
    override fun deleteComment(commentId: Int) = this.commentRepository.delete(this.commentRepository.findById(commentId).orElseThrow { ResourceNotFoundException("Comment", "comment id", commentId) })
}