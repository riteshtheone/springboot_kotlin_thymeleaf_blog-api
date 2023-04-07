package com.realtime.blog_api.payload

class JwtAuthResponse {
    var token: String = ""
    override fun toString(): String = "JwtAuthResponse(token='$token')"
}