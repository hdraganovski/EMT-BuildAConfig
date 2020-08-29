package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.entities.User

interface UserRepo : EntityRepo<User> {
    fun findByEmail(email: String): User
}