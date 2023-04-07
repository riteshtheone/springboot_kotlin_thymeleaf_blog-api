package com.realtime.blog_api.payload

class JwtAuthRequest {
    var username: String = ""
    var password: String = ""
    override fun toString(): String = "JwtAuthRequest(username='$username', password='$password')"
}