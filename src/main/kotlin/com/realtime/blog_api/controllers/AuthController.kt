package com.realtime.blog_api.controllers

import com.realtime.blog_api.payloads.JwtAuthRequest
import com.realtime.blog_api.payloads.JwtAuthResponse
import com.realtime.blog_api.security.jwt.JwtTokenHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    @Autowired private val jwtTokenHelper: JwtTokenHelper,
    @Autowired private val userDetailsService: UserDetailsService,
    @Autowired private val authenticationManager: AuthenticationManager
) {

    @PostMapping("/login")
    fun createToken(@RequestBody request: JwtAuthRequest): ResponseEntity<JwtAuthResponse> {
        this.authenticate(request.username, request.password)
        val userDetails = this.userDetailsService.loadUserByUsername(request.username)
        val token = this.jwtTokenHelper.generateToken(userDetails)
        val response = JwtAuthResponse()
        response.token = token
        return ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK)
    }

    private fun authenticate(username: String, password: String) {
        val authenticationToken = UsernamePasswordAuthenticationToken(username, password)
        try {
        this.authenticationManager.authenticate(authenticationToken)
        }catch (e: DisabledException){
            throw Exception("User is disable")
        }
    }
}