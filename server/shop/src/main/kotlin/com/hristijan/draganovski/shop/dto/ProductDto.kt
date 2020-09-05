package com.hristijan.draganovski.shop.dto

import com.hristijan.draganovski.shop.entities.ProductType

data class ProductDto(val id: String,
                      val title: String,
                      val description: String,
                      val imageUrls: List<String>,
                      val price: Int,
                      val stock: Int,
                      val type: ProductType,
                      val reviews: List<ReviewDto>)