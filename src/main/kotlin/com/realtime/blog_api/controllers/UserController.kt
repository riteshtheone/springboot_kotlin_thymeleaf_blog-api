package com.realtime.blog_api.controllers

import com.realtime.blog_api.beans.UserBean
import com.realtime.blog_api.payloads.ApiResponce
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
    fun createUser(@Valid @RequestBody userBean : UserBean) : ResponseEntity<UserBean> = ResponseEntity<UserBean>(this.userService.createUser(userBean), HttpStatus.CREATED)

    // PUT -> update user
    @PutMapping("/{userId}")
    fun updateUser(@Valid @RequestBody userBean: UserBean, @PathVariable("userId") userId:Int) : ResponseEntity<UserBean> = ResponseEntity.ok(this.userService.updateUser(userBean, userId))

    // DELETE -> delete user
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable("userId") userId:Int) : ResponseEntity<ApiResponce> {
        this.userService.deleteUser(userId)
        return ResponseEntity<ApiResponce>(ApiResponce("user is deleted successfully!!", true), HttpStatus.OK)
    }

    // GET -> get user
    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId:Int) : ResponseEntity<UserBean> = ResponseEntity<UserBean>(this.userService.getUserById(userId), HttpStatus.OK)

    // GET -> get all user
    @GetMapping("/all")
    fun getAllUsers() : ResponseEntity<List<UserBean>> =  ResponseEntity<List<UserBean>>(this.userService.getAllUsers(), HttpStatus.OK)

}