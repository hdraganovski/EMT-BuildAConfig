package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.CartDto
import java.util.*

data class Cart(
        override var id: String,
        var products: List<Product>,
        override var modifiedOn: Date,
        override var createdOn: Date
) : Entity<CartDto> {
    override fun toDto(): CartDto {
        return CartDto(
                id,
                products.map { it.toDto() },
                products.sumBy { it.price }
        )
    }
}