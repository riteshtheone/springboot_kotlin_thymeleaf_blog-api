package com.realtime.blog_api.entities

import jakarta.persistence.*

@Entity
@Table(name = "comments")
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val commentId: Int = 0

    @Column(nullable = false)
    var content: String= ""

    @ManyToOne
    @JoinColumn(name = "post_id")
    var post: Post = Post()

//    @ManyToMany
//    @JoinColumn(name = "user_id")
//    var user: User = User()
}