package com.realtime.blog_api.beans

import jakarta.validation.constraints.NotBlank

class CategoryBean {

    var categoryId: Int = 0

    @NotBlank
    var categoryTitle: String = ""

    var categoryDescription: String = ""
}