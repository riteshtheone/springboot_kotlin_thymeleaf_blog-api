package com.realtime.blog_api.controllers

import com.realtime.blog_api.beans.CategoryBean
import com.realtime.blog_api.payloads.ApiResponse
import com.realtime.blog_api.services.CategoryService

import jakarta.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(@Autowired private val categoryService: CategoryService) {

    // POST -> create category
    @PostMapping("/")
    fun createCategory(@Valid @RequestBody categoryBean: CategoryBean): ResponseEntity<CategoryBean> = ResponseEntity<CategoryBean>(this.categoryService.createCategory(categoryBean), HttpStatus.CREATED)

    // PUT -> update category
    @PutMapping("/{categoryId}")
    fun updateCategory(@Valid @RequestBody categoryBean: CategoryBean, @PathVariable("categoryId") categoryId: Int): ResponseEntity<CategoryBean> = ResponseEntity.ok(this.categoryService.updateCategory(categoryBean, categoryId))

    // DELETE -> delete category
    @DeleteMapping("/{categoryId}")
    fun deleteCategory(@PathVariable("categoryId") categoryId: Int): ResponseEntity<ApiResponse> {
        this.categoryService.deleteCategory(categoryId)
        return ResponseEntity<ApiResponse>(ApiResponse("category is deleted successfully!!", true), HttpStatus.OK)
    }

    // GET -> get category
    @GetMapping("/{categoryId}")
    fun getCategory(@PathVariable("categoryId") categoryId: Int): ResponseEntity<CategoryBean> = ResponseEntity<CategoryBean>(this.categoryService.getCategoryById(categoryId), HttpStatus.OK)

    // GET -> get all category
    @GetMapping("/all")
    fun getAllCategories(): ResponseEntity<List<CategoryBean>> =  ResponseEntity<List<CategoryBean>>(this.categoryService.getAllCategories(), HttpStatus.OK)
}