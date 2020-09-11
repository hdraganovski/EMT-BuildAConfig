package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.dto.CategoryDto
import com.hristijan.draganovski.shop.entities.Category

interface CategoryRepo: EntityRepo<Category, CategoryDto> {
    fun findByDeletedOnIsNull(): List<Category>
    fun findByDeletedOnIsNotNull(): List<Category>
    fun findByName(name: String): Category?
    fun existsByName(name: String): Boolean
}