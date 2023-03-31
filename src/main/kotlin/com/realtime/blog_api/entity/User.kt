package com.realtime.blog_api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    val id = 0

    @Column(nullable = false, length = 100)
    var name = ""

    @Column(unique = true, nullable = false)
    var email = ""

    @Column(nullable = false)
    var password = ""

    @Column
    var about = ""
}