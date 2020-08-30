package com.hristijan.draganovski.shop.entities

import java.util.*

data class Cart(
        override var id: String,
        override var createdOn: Date,
        var products: List<Product>,
        override var modifiedOn: Date
) : Entity