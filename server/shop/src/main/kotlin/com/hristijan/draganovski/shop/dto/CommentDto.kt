package com.hristijan.draganovski.shop.dto

import com.hristijan.draganovski.shop.entities.UserReview


data class CommentDto(val id: String,
                      val body: String,
                      val user: UserReview,
                      val comments: List<CommentDto>,
                      val upvotes: Int)