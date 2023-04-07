package com.realtime.blog_api.service.impl

import com.realtime.blog_api.dto.UserDto
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entity.User
import com.realtime.blog_api.exception.ResourceNotFoundException
import com.realtime.blog_api.service.UserService
import com.realtime.blog_api.utils.mapper.impl.UserMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val userMapper: UserMapper
) : UserService {

    override fun createUser(userDto: UserDto): UserDto =
        this.userMapper.toDomain(this.userRepository.save(this.userMapper.toEntity(userDto)))

    override fun updateUser(userDto: UserDto, userId: Int): UserDto = this.userMapper.toDomain(
        this.userRepository.save(
            this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) }.apply {
                this.name = userDto.name
                this.email = userDto.email
                this.password = userDto.password
                this.about = userDto.about
            }
        )
    )

    override fun getUserById(userId: Int): UserDto = this.userMapper.toDomain(
        this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) })

    override fun getAllUsers(): List<UserDto> =
        userRepository.findAll().stream().map { user: User -> this.userMapper.toDomain(user) }
            .collect(Collectors.toList())

    override fun deleteUser(userId: Int) = this.userRepository.delete(
        this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) })
}
