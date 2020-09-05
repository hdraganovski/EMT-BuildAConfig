package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.request.CreateProduct
import com.hristijan.draganovski.shop.request.UpdateProduct

interface ProductService : MongoDbService<Product, ProductDto> {
    fun updateProduct(request: UpdateProduct): ProductDto
    fun createProduct(request: CreateProduct): ProductDto
}