package com.realtime.blog_api.services

import com.realtime.blog_api.beans.PostBean
import com.realtime.blog_api.payloads.PostResponse

interface PostService {

    //  create
    fun createPost(postBean: PostBean, userId: Int, categoryId: Int): PostBean

    //  update
    fun updatePost(postBean: PostBean, postId: Int): PostBean

    //  get
    fun getPostById(postId: Int): PostBean

    //  get all
    fun getAllPost(pageNumber: Int, pageSize: Int): PostResponse

    //  delete
    fun deletePost(postId: Int)

    //  get all posts by category
    fun getPostByCategory(categoryId: Int): List<PostBean>

    //  get all posts by user
    fun getPostByUser(userId: Int): List<PostBean>

    //  search posts
    fun searchPosts(keyword: String): List<PostBean>

}