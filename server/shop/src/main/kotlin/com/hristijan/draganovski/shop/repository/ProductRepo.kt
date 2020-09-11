package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductRepo : EntityRepo<Product, ProductDto> {
    fun findByCategory(category: String, pageable: Pageable): Page<Product>
}