package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.CommentDto
import java.util.*

data class Comment(
        override var id: String,
        var body: String,
        var user: UserReview,
        var comments: List<Comment>,
        var upvotes: List<String>,
        override var createdOn: Date,
        override var modifiedOn: Date
) : Entity<CommentDto> {
    override fun toDto(): CommentDto {
        return CommentDto(
                id,
                body,
                user,
                comments.map { it.toDto() },
                upvotes.count()
        )
    }
}