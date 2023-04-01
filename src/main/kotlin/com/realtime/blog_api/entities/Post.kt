package com.realtime.blog_api.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

import java.util.Date

@Entity
@Table(name = "posts")
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    val postId: Int = 0

    @Column(nullable = false, length = 100)
    var title: String = ""

    @Column(nullable = false, length = 10000)
    var content: String = ""

    @Column
    var image: String = ""

    @Column(nullable = false)
    var postDate: Date = Date()

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category = Category()

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = User()

}