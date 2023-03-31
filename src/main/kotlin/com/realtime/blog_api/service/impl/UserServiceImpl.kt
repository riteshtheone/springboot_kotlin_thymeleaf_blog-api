package com.realtime.blog_api.service.impl

import com.realtime.blog_api.bean.UserBean
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entity.User
import com.realtime.blog_api.exception.ResourceNotFoundException
import com.realtime.blog_api.service.UserService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository) : UserService {

    override fun createUser(userBean: UserBean): UserBean {
        return this.getUserBeanByUser(this.userRepository.save(this.getUserByBean(userBean)))
    }

    override fun updateUser(userBean: UserBean, userId:Int) : UserBean {
        val user = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId.toLong()) }
        user.name = userBean.name
        user.email = userBean.email
        user.password = userBean.password
        return this.getUserBeanByUser(this.userRepository.save(user))
    }

    override fun getUserById(userId: Int): UserBean {
        return this.getUserBeanByUser(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId.toLong()) })
    }

    override fun getAllUsers(): List<UserBean> {
        return userRepository.findAll().stream().map { user: User -> getUserBeanByUser(user) }.collect(Collectors.toList())
    }

    override fun deleteUser(userId: Int) {
        this.userRepository.deleteById(userId)
    }

    private fun getUserByBean(userBean: UserBean): User {
        val user = User()
        user.name = userBean.name
        user.email = userBean.email
        user.password = userBean.password
        user.about = userBean.about
        return user
    }

    private fun getUserBeanByUser(user: User): UserBean {
        val userBean = UserBean()
        userBean.id = user.id
        userBean.name = user.name
        userBean.email = user.email
        userBean.password = user.password
        userBean.about = user.about
        return userBean
    }
}
