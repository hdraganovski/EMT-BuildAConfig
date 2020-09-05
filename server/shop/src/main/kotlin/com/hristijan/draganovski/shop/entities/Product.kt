package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.ProductDto
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "product")
data class Product(
        override var id: String,
        var title: String,
        var description: String,
        var imageUrls: List<String>,
        var price: Int,
        var stock: Int,
        var type: ProductType,
        var reviews: List<Review>,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity<ProductDto> {
    override fun toDto(): ProductDto {
        return ProductDto(
                id,
                title,
                description,
                imageUrls,
                price,
                stock,
                type,
                reviews.map { it.toDto() }
        )
    }
}