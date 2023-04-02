package com.realtime.blog_api.controllers

import com.realtime.blog_api.beans.PostBean
import com.realtime.blog_api.payloads.ApiResponse
import com.realtime.blog_api.payloads.PostResponse
import com.realtime.blog_api.services.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostController(@Autowired private val postService: PostService) {

    // POST -> create post
    @PostMapping("/user/{userId}/category/{categoryId}/post")
    fun createPost(@RequestBody postBean : PostBean, @PathVariable userId: Int, @PathVariable categoryId: Int) : ResponseEntity<PostBean> = ResponseEntity<PostBean>(this.postService.createPost(postBean, userId, categoryId), HttpStatus.CREATED)

    // PUT -> update post
    @PutMapping("/post/{postId}")
    fun updatePost(@RequestBody postBean: PostBean, @PathVariable("postId") postId:Int) : ResponseEntity<PostBean> = ResponseEntity.ok(this.postService.updatePost(postBean, postId))

    // DELETE -> delete post
    @DeleteMapping("/post/{postId}")
    fun deletePost(@PathVariable postId:Int) : ResponseEntity<ApiResponse> {
        this.postService.deletePost(postId)
        return ResponseEntity<ApiResponse>(ApiResponse("post is deleted successfully!!", true), HttpStatus.OK)
    }

    //  GET -> get post
    @GetMapping("/post/{postId}")
    fun getPost(@PathVariable("postId") postId:Int) : ResponseEntity<PostBean> = ResponseEntity<PostBean>(this.postService.getPostById(postId), HttpStatus.OK)

    // GET -> get all post
    @GetMapping("/post/all")
    fun getAllPosts(
        @RequestParam(value = "pageNumber", defaultValue = "0", required = false) pageNumber: Int,
        @RequestParam(value = "pageSize", defaultValue = "3", required = false) pageSize: Int
        ) : ResponseEntity<PostResponse> = ResponseEntity<PostResponse>(this.postService.getAllPost(pageNumber, pageSize), HttpStatus.OK)

    // get post by user id
    @GetMapping("/user/{userId}/post")
    fun getPostByUser(@PathVariable userId: Int): ResponseEntity<List<PostBean>> = ResponseEntity<List<PostBean>>(this.postService.getPostByUser(userId), HttpStatus.OK)

    // get post by category id
    @GetMapping("/category/{categoryId}/post")
    fun getPostByCategory(@PathVariable categoryId: Int): ResponseEntity<List<PostBean>> = ResponseEntity<List<PostBean>>(this.postService.getPostByCategory(categoryId), HttpStatus.OK)

}