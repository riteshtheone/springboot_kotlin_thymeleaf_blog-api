//package com.realtime.blog_api.services
//
//import com.realtime.blog_api.beans.PostBean
//import com.realtime.blog_api.entities.Post
//
//interface PostService {
//
//    //  create
//    fun createPost(postBean:PostBean, userId: Int, categoryId: Int): Post
//
//    //  update
//    fun updatePost(postBean:PostBean, postId: Int): PostBean
//
//    //  get
//    fun getPostById(postId:Int): PostBean
//
//    //  get all
//    fun getAllPosts(): List<PostBean>
//
//    //  delete
//    fun deletePost(postId: Int)
//
//    //  get all posts by category
//    fun getPostByCategoryId(categoryId: Int): List<PostBean>
//
//    //  get all posts by user
//    fun getPostByUserId(userId: Int): List<PostBean>
//
//    //  search posts
//    fun searchPosts(keyword: String): List<PostBean>
//
//}