package com.realtime.blog_api.payloads

class JwtAuthResponse {
    var token: String = ""
    override fun toString(): String = "JwtAuthResponse(token='$token')"
}