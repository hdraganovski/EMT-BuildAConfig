package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.dto.UserDto
import com.hristijan.draganovski.shop.entities.User

interface UserRepo : EntityRepo<User, UserDto> {
    fun findByEmail(email: String): User
    fun existsByEmail(email: String): Boolean
}