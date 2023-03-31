package com.realtime.blog_api.controller

import com.realtime.blog_api.bean.UserBean
import com.realtime.blog_api.payload.ApiResponce
import com.realtime.blog_api.service.UserService
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

    // CREATE USER
    @PostMapping("/")
    fun createUser(@RequestBody userBean : UserBean) : ResponseEntity<UserBean>{
        return ResponseEntity<UserBean>(this.userService.createUser(userBean),HttpStatus.CREATED)
    }

    // UPDATE USER
    @PutMapping("/{userId}")
    fun updateUser(@RequestBody userBean: UserBean, @PathVariable("userId") userId:Int) : ResponseEntity<UserBean> {
        return ResponseEntity.ok(this.userService.updateUser(userBean, userId))
    }

    // DELETE USER
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId:Int) : ResponseEntity<ApiResponce> {
        this.userService.deleteUser(userId)
        return ResponseEntity<ApiResponce>(ApiResponce("User deleted successfully", true), HttpStatus.OK)
    }

    // GET USER
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId:Int) : ResponseEntity<UserBean> {
        return ResponseEntity<UserBean>(this.userService.getUserById(userId), HttpStatus.OK)
    }

    // GET ALL USER
    @GetMapping("/")
    fun getAllUsers() : ResponseEntity<List<UserBean>> {
        return ResponseEntity<List<UserBean>>(this.userService.getAllUsers(), HttpStatus.OK)
    }
}