package com.hristijan.draganovski.shop.request

import com.hristijan.draganovski.shop.entities.ProductType


data class CreateProduct(
        var title: String,
        var description: String,
        var imageUrls: List<String>,
        var price: Int,
        var stock: Int,
        var type: ProductType
)

data class UpdateProduct(
        var id: String,
        var title: String,
        var description: String,
        var imageUrls: List<String>,
        var price: Int,
        var stock: Int,
        var type: ProductType
)
