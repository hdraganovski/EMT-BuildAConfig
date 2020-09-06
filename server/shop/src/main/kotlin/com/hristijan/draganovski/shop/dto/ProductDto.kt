package com.hristijan.draganovski.shop.dto

data class ProductDto(val id: String,
                      val title: String,
                      val description: String,
                      val imageUrls: List<String>,
                      val price: Int,
                      val stock: Int,
                      val reviews: List<ReviewDto>)