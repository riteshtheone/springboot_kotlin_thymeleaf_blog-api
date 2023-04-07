package com.realtime.blog_api.services

import com.realtime.blog_api.dto.CategoryDto

interface CategoryService {

    //  create
    fun createCategory(categoryDto: CategoryDto) : CategoryDto

    //  update
    fun updateCategory(categoryDto: CategoryDto, categoryId:Int) : CategoryDto

    // get
    fun getCategoryById(categoryId:Int) : CategoryDto

    //  get all
    fun getAllCategories() : List<CategoryDto>

    //  delete
    fun deleteCategory(categoryId:Int)
}