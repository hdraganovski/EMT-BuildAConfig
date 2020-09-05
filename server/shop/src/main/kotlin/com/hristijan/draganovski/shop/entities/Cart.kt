package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.CartDto
import java.util.*

data class Cart(
        override var id: String,
        override var createdOn: Date,
        var products: List<Product>,
        override var modifiedOn: Date
) : Entity<CartDto> {
    override fun toDto(): CartDto {
        return CartDto(
                id,
                products.map { it.toDto() },
                products.sumBy { it.price }
        )
    }
}