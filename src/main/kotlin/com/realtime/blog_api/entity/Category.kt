package com.realtime.blog_api.entity

import jakarta.persistence.*

@Entity @Table(name = "categories")
data class Category (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "category_id")
    val id: Int,

    @Column(unique = true, nullable = false, length = 100)
    var title: String,

    @Column
    var description: String,

){
    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var posts: List<Post> = ArrayList()
}