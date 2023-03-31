package com.realtime.blog_api.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    val id: Int = -1

    @Column(nullable = false, length = 100)
    lateinit var name: String

    @Column(unique = true, nullable = false)
    lateinit var email: String

    @Column(nullable = false)
    lateinit var password: String

    @Column
    lateinit var about: String

//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    var posts: List<Post> = ArrayList()

}