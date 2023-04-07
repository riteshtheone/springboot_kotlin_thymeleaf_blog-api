package com.realtime.blog_api.utils.mapper.impl

import com.realtime.blog_api.dto.CommentDto
import com.realtime.blog_api.entity.Comment
import com.realtime.blog_api.utils.mapper.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CommentMapper (
    @Autowired private val userMapper: UserMapper,
    @Autowired private val postMapper: PostMapper
    ): Mapper<Comment,  CommentDto> {
    override fun toDomain(entity: Comment): CommentDto = CommentDto (
        entity.id,
        entity.comment,
        this.postMapper.toDomain(entity.post),
        this.userMapper.toDomain(entity.user)
    )

    override fun toEntity(domain: CommentDto): Comment = Comment (
        domain.id,
        domain.comment
    )
}