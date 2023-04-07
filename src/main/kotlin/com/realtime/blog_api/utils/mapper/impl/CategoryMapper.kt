package com.realtime.blog_api.utils.mapper.impl

import com.realtime.blog_api.dto.CategoryDto
import com.realtime.blog_api.entity.Category
import com.realtime.blog_api.utils.mapper.Mapper
import org.springframework.stereotype.Component

@Component
class CategoryMapper: Mapper<Category, CategoryDto> {
    override fun toDomain(entity: Category): CategoryDto = CategoryDto(
        id = entity.id,
        title = entity.title,
        description = entity.description,
    )
    override fun toEntity(domain: CategoryDto): Category =  Category(
        id = domain.id,
        title = domain.title,
        description = domain.description,
    )
}