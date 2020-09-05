package com.hristijan.draganovski.shop.dto

data class CartDto(
        val id: String,
        val products: List<ProductDto>,
        val totalPrice: Int
)