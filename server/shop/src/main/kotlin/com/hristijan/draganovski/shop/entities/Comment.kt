package com.hristijan.draganovski.shop.entities

import java.util.*

data class Comment(
        override var id: String,
        var body: String,
        var user: UserReview,
        var comments: List<Comment>,
        var upvotes: List<String>,
        override var createdOn: Date,
        override var modifiedOn: Date
): Entity