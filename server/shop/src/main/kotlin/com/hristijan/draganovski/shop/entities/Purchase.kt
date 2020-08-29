package com.hristijan.draganovski.shop.entities

import java.util.*

data class Purchase(
        override var id: String,
        var cart: Cart,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity