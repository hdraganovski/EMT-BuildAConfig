package com.hristijan.draganovski.shop.request

data class SignUp(
        var email: String,
        var password: String,
        var imageUrl: String,
        var fullName: String
)