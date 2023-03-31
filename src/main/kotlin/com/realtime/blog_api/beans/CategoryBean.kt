package com.realtime.blog_api.beans

import jakarta.validation.constraints.NotBlank

class CategoryBean {
    var categoryId = -1

    @NotBlank
    var categoryTitle = ""

    var categoryDescription = ""
}