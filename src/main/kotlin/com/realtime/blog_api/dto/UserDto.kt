package com.realtime.blog_api.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserDto(
    val id: Int,

    @NotBlank
    var name: String,

    @Email @NotBlank
    var email: String,

    @NotBlank @Size(min = 2, max = 24)
    var password: String,

    @NotBlank
    var about: String,
)