package com.realtime.blog_api.entity

import jakarta.persistence.*

@Entity @Table(name = "users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "user_id")
    val id: Int,

    @Column(nullable = false, length = 100)
    var name: String,

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Column
    var about: String,
){
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var posts: List<Post> = ArrayList()

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var comments: List<Comment> = ArrayList()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user", referencedColumnName = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role", referencedColumnName = "id")]
    )
    var roles: List<Role> = ArrayList()
}
