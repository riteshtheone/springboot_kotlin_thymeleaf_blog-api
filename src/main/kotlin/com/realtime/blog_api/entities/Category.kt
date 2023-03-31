package com.realtime.blog_api.entities

import jakarta.persistence.*

@Entity
@Table(name = "categories")
class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val categoryId = -1

    @Column(unique = true, nullable = false, length = 100)
    lateinit var categoryTitle: String

    @Column
    lateinit var categoryDescription: String

//    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    var posts: List<Post> = ArrayList()

}