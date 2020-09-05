package com.hristijan.draganovski.shop.dto

data class UserDto(
        val id: String,
        val email: String,
        val fullName: String,
        val imageUrl: String,
        val cart: CartDto,
        val purchases: List<PurchaseDto>,
        val configurations: List<ConfigurationDto>
)