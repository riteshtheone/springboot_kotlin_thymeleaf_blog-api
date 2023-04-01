package com.realtime.blog_api.beans

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UserBean {
    var id: Int = 0

    @NotBlank
    var name: String = ""

    @Email
    @NotBlank
    var email: String = ""

    @NotBlank
    @Size(min = 2, max = 24)
    var password: String = ""

    @NotBlank
    var about: String = ""

}