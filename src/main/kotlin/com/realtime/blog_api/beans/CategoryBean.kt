package com.realtime.blog_api.beans

import jakarta.validation.constraints.NotBlank

class CategoryBean {

    var categoryId: Int = -1

    @NotBlank
    lateinit var categoryTitle: String

    lateinit var categoryDescription: String
}