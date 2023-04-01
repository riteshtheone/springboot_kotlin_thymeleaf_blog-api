package com.realtime.blog_api.controllers

import com.realtime.blog_api.beans.PostBean
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
//    @PutMapping("/{postId}")
//    fun updatePost(@Valid @RequestBody postBean: PostBean, @PathVariable("postId") postId:Int) : ResponseEntity<PostBean> = ResponseEntity.ok(this.postService.updatePost(postBean, postId))
//
//    // DELETE -> delete post
//    @DeleteMapping("/{postId}")
//    fun deletePost(@PathVariable("postId") postId:Int) : ResponseEntity<ApiResponce> {
//        this.postService.deletePost(postId)
//        return ResponseEntity<ApiResponce>(ApiResponce("post is deleted successfully!!", true), HttpStatus.OK)
//    }
//
    // GET -> get post
//    @GetMapping("/post/{postId}")
//    fun getPost(@PathVariable("postId") postId:Int) : ResponseEntity<Post> = ResponseEntity<Post>(this.postService.getPostById(postId), HttpStatus.OK)
//
//    // GET -> get all post
//    @GetMapping("/")
//    fun getAllPosts() : ResponseEntity<List<PostBean>> =  ResponseEntity<List<PostBean>>(this.postService.getAllPosts(), HttpStatus.OK)

}