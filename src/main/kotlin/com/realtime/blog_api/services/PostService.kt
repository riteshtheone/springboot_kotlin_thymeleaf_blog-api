package com.realtime.blog_api.services

import com.realtime.blog_api.beans.PostBean

interface PostService {

    //  create
    fun createPost(postBean: PostBean, userId: Int, categoryId: Int): PostBean

    //  update
    fun updatePost(postBean: PostBean, postId: Int): PostBean

    //  get
    fun getPostById(postId: Int): PostBean

    //  get all
    fun getAllPost(): List<PostBean>

    //  delete
    fun deletePost(postId: Int)

    //  get all posts by category
    fun getPostByCategory(categoryId: Int): List<PostBean>

    //  get all posts by user
    fun getPostByUser(userId: Int): List<PostBean>

    //  search posts
    fun searchPosts(keyword: String): List<PostBean>

}