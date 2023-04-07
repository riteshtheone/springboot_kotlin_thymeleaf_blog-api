package com.realtime.blog_api.services

import com.realtime.blog_api.dto.PostDto
import com.realtime.blog_api.payloads.PostResponse

interface PostService {

    //  create
    fun createPost(postDto: PostDto, userId: Int, categoryId: Int): PostDto

    //  update
    fun updatePost(postDto: PostDto, postId: Int): PostDto

    //  get
    fun getPostById(postId: Int): PostDto

    //  get all
    fun getAllPost(pageNumber: Int, pageSize: Int, sortBy: String, sortDir: String): PostResponse

    //  delete
    fun deletePost(postId: Int)

    //  get all posts by category
    fun getPostByCategory(categoryId: Int): List<PostDto>

    //  get all posts by user
    fun getPostByUser(userId: Int): List<PostDto>

    //  search posts
    fun searchPosts(keyword: String): List<PostDto>

}