package com.realtime.blog_api.services.impl

import com.realtime.blog_api.beans.CategoryBean
import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.entities.Category
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.services.CategoryService

import org.modelmapper.ModelMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class CategoryServiceImpl(@Autowired private val categoryRepository: CategoryRepository, @Autowired private val modelMapper: ModelMapper): CategoryService {

    override fun createCategory(categoryBean: CategoryBean): CategoryBean = this.modelMapper.map(this.categoryRepository.save(this.modelMapper.map(categoryBean, Category::class.java)), CategoryBean::class.java)

    override fun updateCategory(categoryBean: CategoryBean, categoryId: Int): CategoryBean {
        val category: Category = this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) }
        category.categoryTitle = categoryBean.categoryTitle
        category.categoryDescription = categoryBean.categoryDescription
        return this.modelMapper.map(category, CategoryBean::class.java)
    }

    override fun getCategoryById(categoryId: Int): CategoryBean = this.modelMapper.map(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) }, CategoryBean::class.java)
    override fun getAllCategories(): List<CategoryBean> = this.categoryRepository.findAll().stream().map { category: Category -> this.modelMapper.map(category, CategoryBean::class.java) }.collect(Collectors.toList())
    override fun deleteCategory(categoryId: Int) = this.categoryRepository.delete(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId)})

}