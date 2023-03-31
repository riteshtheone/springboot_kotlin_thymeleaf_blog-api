//package com.realtime.blog_api.entities
//
//import jakarta.persistence.Column
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.persistence.JoinColumn
//import jakarta.persistence.ManyToOne
//import jakarta.persistence.Table
//
//import java.util.Date
//
//@Entity
//@Table(name = "posts")
//class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "post_id")
//    val postId: Int = -1
//
//    @Column(nullable = false, length = 100)
//    lateinit var title: String
//
//    @Column(nullable = false, length = 10000)
//    lateinit var content: String
//
//    @Column
//    lateinit var image: String
//
//    @Column(nullable = false)
//    lateinit var postDate: Date
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    lateinit var user: User
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    lateinit var category: Category
//
//}