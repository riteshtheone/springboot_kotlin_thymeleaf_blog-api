package com.realtime.blog_api.utils.mapper.impl

import com.realtime.blog_api.dto.PostDto
import com.realtime.blog_api.entities.Post
import com.realtime.blog_api.utils.mapper.Mapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PostMapper(
    @Autowired private val userMapper: UserMapper,
    @Autowired private val categoryMapper: CategoryMapper
    ): Mapper<Post, PostDto> {
    override fun toDomain(entity: Post): PostDto = PostDto(
        entity.id,
        entity.title,
        entity.content,
        entity.image,
        entity.postDate,
        this.categoryMapper.toDomain(entity.category),
        this.userMapper.toDomain(entity.user)

    )
    override fun toEntity(domain: PostDto): Post = Post(
        domain.id,
        domain.title,
        domain.content,
        domain.image
    )
}