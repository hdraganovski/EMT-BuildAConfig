package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.UserDto
import com.hristijan.draganovski.shop.entities.User
import com.hristijan.draganovski.shop.request.SignUp
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService: MongoDbService<User, UserDto>, UserDetailsService {
    fun signUp(singUpRequest: SignUp)

    fun getSelf(email: String): UserDto
}