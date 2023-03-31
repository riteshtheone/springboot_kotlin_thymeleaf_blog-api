package com.realtime.blog_api.services

import com.realtime.blog_api.beans.UserBean

interface UserService {

    //  create
    fun createUser(userBean: UserBean): UserBean

    //  update
    fun updateUser(userBean: UserBean, userId: Int): UserBean

    //  get
    fun getUserById(userId: Int): UserBean

    //  get all
    fun getAllUsers(): List<UserBean>

    //  delete
    fun deleteUser(userId: Int)
}