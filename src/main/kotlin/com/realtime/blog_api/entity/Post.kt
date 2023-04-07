package com.realtime.blog_api.entity

import jakarta.persistence.*

import java.util.Date

@Entity @Table(name = "posts")
data class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "post_id")
    val id: Int,

    @Column(nullable = false, length = 100)
    var title: String,

    @Column(nullable = false, length = 10000)
    var content: String,

    @Column
    var image: String,
){
    @Column(nullable = false)
    lateinit var postDate: Date

    @ManyToOne @JoinColumn(name = "category_id")
    lateinit var category: Category

    @ManyToOne @JoinColumn(name = "user_id")
    lateinit var user: User

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var comments: List<Comment> = ArrayList()
}