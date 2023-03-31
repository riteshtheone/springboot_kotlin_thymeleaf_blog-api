package com.realtime.blog_api.beans

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UserBean {
    var id = -1

    @NotBlank
    var name = ""

    @Email
    @NotBlank
    var email = ""

    @NotBlank
    @Size(min = 2, max = 24)
    var password = ""

    @NotBlank
    var about = ""

}