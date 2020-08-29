package com.hristijan.draganovski.shop.entities

import java.util.*

data class Configuration(
        override var id: String,
        var products: List<String>,
        var upvotes: List<String>,
        var comments: List<Comment>,
        override var createdOn: Date,
        override var modifiedOn: Date
): Entity