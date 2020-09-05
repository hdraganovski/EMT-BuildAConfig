package com.hristijan.draganovski.shop.dto

import com.hristijan.draganovski.shop.entities.UserReview

data class ReviewDto(val id: String,
                     val userReview: UserReview,
                     val body: String,
                     val stars: Int,
                     val upvotes: Int)