package com.realtime.blog_api.services

import com.realtime.blog_api.beans.CategoryBean

interface CategoryService {

    //  create
    fun createCategory(categoryBean: CategoryBean) : CategoryBean

    //  update
    fun updateCategory(categoryBean: CategoryBean, categoryId:Int) : CategoryBean

    // get
    fun getCategoryById(categoryId:Int) : CategoryBean

    //  get all
    fun getAllCategories() : List<CategoryBean>

    //  delete
    fun deleteCategory(categoryId:Int)
}