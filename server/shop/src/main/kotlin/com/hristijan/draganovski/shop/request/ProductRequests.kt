package com.hristijan.draganovski.shop.request


data class ProductRequest(
        var title: String,
        var description: String,
        var imageUrls: List<String>,
        var price: Int,
        var stock: Int,
        var category: String
)
