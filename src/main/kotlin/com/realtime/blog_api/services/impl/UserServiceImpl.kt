package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.UserBean
import com.realtime.blog_api.dao.UserRepository
import com.realtime.blog_api.entities.User
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.services.UserService

import org.modelmapper.ModelMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository, @Autowired private val modelMapper: ModelMapper): UserService {

    override fun createUser(userBean: UserBean): UserBean = this.getUserBeanByUser(this.userRepository.save(this.getUserByBean(userBean)))

    override fun updateUser(userBean: UserBean, userId:Int) : UserBean {
        val user = this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) }
        user.name = userBean.name
        user.email = userBean.email
        user.password = userBean.password
        user.about = userBean.about
        return this.getUserBeanByUser(this.userRepository.save(user))
    }

    override fun getUserById(userId: Int) : UserBean = this.getUserBeanByUser(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) })
    override fun getAllUsers() : List<UserBean> = userRepository.findAll().stream().map { user: User -> getUserBeanByUser(user) }.collect(Collectors.toList())
    override fun deleteUser(userId: Int) = this.userRepository.delete(this.userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User", "Id", userId) })

    private fun getUserByBean(userBean: UserBean): User = this.modelMapper.map(userBean, User::class.java)
    private fun getUserBeanByUser(user: User): UserBean = this.modelMapper.map(user, UserBean::class.java)

}
