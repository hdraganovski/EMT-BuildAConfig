package com.hristijan.draganovski.shop.entities

import java.util.*

data class Review(
        override var id: String,
        override var createdOn: Date,
        var userReview: UserReview,
        var body: String,
        var stars: Int,
        var upvoteBy: List<String>,
        override var modifiedOn: Date
): Entity