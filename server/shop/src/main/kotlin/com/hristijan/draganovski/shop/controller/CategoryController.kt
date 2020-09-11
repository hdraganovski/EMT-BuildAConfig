package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.dto.CategoryDto
import com.hristijan.draganovski.shop.dto.Message
import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.request.CategoryRequest
import com.hristijan.draganovski.shop.service.CategoryService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun getCategories(): List<CategoryDto> {
        return categoryService.getAll()
    }

    @PostMapping
    fun createCategory(@RequestBody request: CategoryRequest): CategoryDto {
        return categoryService.createCategory(request)
    }

    @PutMapping("{id}")
    fun updateCategory(@RequestBody request: CategoryRequest, @PathVariable id: String): CategoryDto {
        return categoryService.updateCategory(request, id)
    }

    @DeleteMapping("{id}")
    fun deleteCategory(@PathVariable id: String): Message {
        categoryService.delete(id)
        return Message("OK")
    }
}