//package com.realtime.blog_api.security.service.impl
//
//import com.realtime.blog_api.dao.UserRepository
//import com.realtime.blog_api.entity.User
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Service
//
//@Service
//class UserDetailsServiceImpl(@Autowired private val userRepository: UserRepository) : UserDetailsService {
//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(username: String): UserDetails {
//        val user: User = this.userRepository.findByEmail(username)
//        return UserDetailsImpl(user)
//    }
//}