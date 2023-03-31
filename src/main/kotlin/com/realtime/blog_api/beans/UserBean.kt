package com.realtime.blog_api.beans

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UserBean {
    var id: Int = -1

    @NotBlank
    lateinit var name: String

    @Email
    @NotBlank
    lateinit var email: String

    @NotBlank
    @Size(min = 2, max = 24)
    lateinit var password: String

    @NotBlank
    lateinit var about: String

}