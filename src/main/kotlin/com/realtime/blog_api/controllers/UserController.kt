package com.realtime.blog_api.controllers

import com.realtime.blog_api.dto.UserDto
import com.realtime.blog_api.payloads.ApiResponse
import com.realtime.blog_api.services.UserService

import jakarta.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(@Autowired private val userService: UserService) {

    // POST -> create user
    @PostMapping("/")
    fun createUser(@Valid @RequestBody userDto: UserDto) : ResponseEntity<UserDto> = ResponseEntity<UserDto>(this.userService.createUser(userDto), HttpStatus.CREATED)

//     PUT -> update user
    @PutMapping("/{userId}")
    fun updateUser(@Valid @RequestBody userDto: UserDto, @PathVariable("userId") userId:Int) : ResponseEntity<UserDto> = ResponseEntity.ok(this.userService.updateUser(userDto, userId))

    // DELETE -> delete user
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable("userId") userId:Int) : ResponseEntity<ApiResponse> {
        this.userService.deleteUser(userId)
        return ResponseEntity<ApiResponse>(ApiResponse("user is deleted successfully!!", true), HttpStatus.OK)
    }

    // GET -> get user
    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId:Int) : ResponseEntity<UserDto> = ResponseEntity<UserDto>(this.userService.getUserById(userId), HttpStatus.OK)

    // GET -> get all user
    @GetMapping("/all")
    fun getAllUsers() : ResponseEntity<List<UserDto>> =  ResponseEntity<List<UserDto>>(this.userService.getAllUsers(), HttpStatus.OK)

}