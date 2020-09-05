package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.PurchaseDto
import java.util.*

data class Purchase(
        override var id: String,
        var cart: Cart,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity<PurchaseDto> {
    override fun toDto(): PurchaseDto {
        return PurchaseDto(id, cart.toDto())
    }
}