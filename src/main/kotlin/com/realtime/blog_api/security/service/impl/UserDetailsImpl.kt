//package com.realtime.blog_api.security.service.impl
//
//import com.realtime.blog_api.entities.Role
//import com.realtime.blog_api.entities.User
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import java.util.stream.Collectors
//
//class UserDetailsImpl(private val user: User): UserDetails {
//
//    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = this.user.roles.stream().map { role: Role -> SimpleGrantedAuthority(role.name) }.collect(Collectors.toList())
//    override fun getPassword(): String = this.user.password
//    override fun getUsername(): String = this.user.email
//    override fun isAccountNonExpired(): Boolean = true
//    override fun isAccountNonLocked(): Boolean = true
//    override fun isCredentialsNonExpired(): Boolean = true
//    override fun isEnabled(): Boolean = true
//}