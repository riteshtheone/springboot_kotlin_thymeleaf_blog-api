package com.realtime.blog_api.entity

import jakarta.persistence.*

@Entity @Table(name = "comments")
data class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "comment_id")
    val id: Int,

    @Column(nullable = false)
    var comment: String,

){
    @ManyToOne @JoinColumn(name = "post_id")
    lateinit var post: Post

    @ManyToOne @JoinColumn(name = "user_id")
    lateinit var user: User
}