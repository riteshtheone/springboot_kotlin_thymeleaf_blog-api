package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.CommentBean
import com.realtime.blog_api.dao.CommentRepository
import com.realtime.blog_api.dao.PostRepository
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
        TODO("Not yet implemented")
    }

    override fun deleteComment(commendId: Int) {
        TODO("Not yet implemented")
    }
}