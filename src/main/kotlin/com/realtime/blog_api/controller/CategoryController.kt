package com.realtime.blog_api.controller

import com.realtime.blog_api.dto.CategoryDto
import com.realtime.blog_api.payload.ApiResponse
import com.realtime.blog_api.service.CategoryService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import jakarta.validation.Valid

@RestController @RequestMapping("/api/category")
class CategoryController(@Autowired private val categoryService: CategoryService) {

    // POST -> create category
    @PostMapping("/")
    fun createCategory(@Valid @RequestBody categoryDto: CategoryDto): ResponseEntity<CategoryDto> = ResponseEntity<CategoryDto>(this.categoryService.createCategory(categoryDto), HttpStatus.CREATED)

    // PUT -> update category
    @PutMapping("/{categoryId}")
    fun updateCategory(@Valid @RequestBody categoryDto: CategoryDto, @PathVariable("categoryId") categoryId: Int): ResponseEntity<CategoryDto> = ResponseEntity.ok(this.categoryService.updateCategory(categoryDto, categoryId))

    // DELETE -> delete category
    @DeleteMapping("/{categoryId}")
    fun deleteCategory(@PathVariable("categoryId") categoryId: Int): ResponseEntity<ApiResponse> {
        this.categoryService.deleteCategory(categoryId)
        return ResponseEntity<ApiResponse>(ApiResponse("category is deleted successfully!!", true), HttpStatus.OK)
    }

    // GET -> get category
    @GetMapping("/{categoryId}")
    fun getCategory(@PathVariable("categoryId") categoryId: Int): ResponseEntity<CategoryDto> = ResponseEntity<CategoryDto>(this.categoryService.getCategoryById(categoryId), HttpStatus.OK)

    // GET -> get all category
    @GetMapping("/all")
    fun getAllCategories(): ResponseEntity<List<CategoryDto>> = ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategories(), HttpStatus.OK)
}