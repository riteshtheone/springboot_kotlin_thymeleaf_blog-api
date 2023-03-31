package com.realtime.blog_api.service

import com.realtime.blog_api.bean.UserBean
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun createUser(userBean:UserBean) :UserBean
    fun updateUser(userBean:UserBean, userId:Int) : UserBean
    fun getUserById(userId:Int) : UserBean
    fun getAllUsers() : List<UserBean>
    fun deleteUser(userId:Int)
}