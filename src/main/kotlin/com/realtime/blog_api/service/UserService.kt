package com.realtime.blog_api.service

import com.realtime.blog_api.dto.UserDto

interface UserService {

    //  create
    fun createUser(userDto: UserDto): UserDto

    //  update
    fun updateUser(userDto: UserDto, userId: Int): UserDto

//    //  get
    fun getUserById(userId: Int): UserDto

    //  get all
    fun getAllUsers(): List<UserDto>

    //  delete
    fun deleteUser(userId: Int)
}