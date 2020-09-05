package com.hristijan.draganovski.shop.dto

import com.hristijan.draganovski.shop.entities.Comment

data class ConfigurationDto(var id: String,
                            var products: List<String>,
                            var upvotes: Int,
                            var comments: List<CommentDto>)