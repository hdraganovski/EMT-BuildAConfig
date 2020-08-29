package com.hristijan.draganovski.shop.entities

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "user")
data class User(
        override var id: String,
        var email: String,
        var password: String,
        var fullName: String,
        var imageUrl: String,
        var roles: List<Role>,
        var cart: Cart,
        var purchases: List<Purchase>,
        var configurations: List<Configuration>,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity