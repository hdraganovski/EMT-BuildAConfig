package com.hristijan.draganovski.shop.entities

import org.springframework.data.mongodb.core.mapping.Document

data class UserReview(
        var id: String,
        var fullName: String,
        var imageUrl: String
)