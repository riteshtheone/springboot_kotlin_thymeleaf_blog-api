package com.realtime.blog_api.utils.mapper.impl

import com.realtime.blog_api.dto.UserDto
import com.realtime.blog_api.entities.User
import com.realtime.blog_api.utils.mapper.Mapper
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<User, UserDto> {
    override fun toDomain(entity: User): UserDto = UserDto (
        id = entity.id,
        name = entity.name,
        email = entity.email,
        password = entity.password,
        about = entity.about
    )
    override fun toEntity(domain: UserDto): User = User (
        id = domain.id,
        name = domain.name,
        email = domain.email,
        password = domain.password,
        about = domain.about
    )
}