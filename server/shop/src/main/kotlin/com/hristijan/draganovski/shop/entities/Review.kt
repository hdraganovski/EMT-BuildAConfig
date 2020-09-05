package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.ReviewDto
import java.util.*

data class Review(
        override var id: String,
        var userReview: UserReview,
        var body: String,
        var stars: Int,
        var upvoteBy: List<String>,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity<ReviewDto> {
    override fun toDto(): ReviewDto {
        return ReviewDto(
                id, userReview, body, stars, upvoteBy.count()
        )
    }
}