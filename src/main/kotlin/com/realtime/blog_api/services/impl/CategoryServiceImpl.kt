package com.realtime.blog_api.services.impl

import com.realtime.blog_api.dao.CategoryRepository
import com.realtime.blog_api.dto.CategoryDto
import com.realtime.blog_api.entities.Category
import com.realtime.blog_api.exceptions.ResourceNotFoundException
import com.realtime.blog_api.services.CategoryService
import com.realtime.blog_api.utils.mapper.impl.CategoryMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.stream.Collectors

@Service
class CategoryServiceImpl(
    @Autowired private val categoryRepository: CategoryRepository,
    @Autowired private val categoryMapper: CategoryMapper,
    ) : CategoryService {

    override fun createCategory(categoryDto: CategoryDto): CategoryDto = this.categoryMapper.toDomain(this.categoryRepository.save(this.categoryMapper.toEntity(categoryDto)))
    override fun updateCategory(categoryDto: CategoryDto, categoryId: Int): CategoryDto = this.categoryMapper.toDomain(
        this.categoryRepository.save(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) }.apply {
            this.title = categoryDto.title
            this.description = categoryDto.description
        })
    )
    override fun getCategoryById(categoryId: Int): CategoryDto = this.categoryMapper.toDomain(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) })
    override fun getAllCategories(): List<CategoryDto> = this.categoryRepository.findAll().stream().map { category: Category -> this.categoryMapper.toDomain(category) }.collect(Collectors.toList())
    override fun deleteCategory(categoryId: Int) = this.categoryRepository.delete(this.categoryRepository.findById(categoryId).orElseThrow { ResourceNotFoundException("Category", "Id", categoryId) })
}