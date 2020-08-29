package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.entities.Role
import com.hristijan.draganovski.shop.entities.User
import com.hristijan.draganovski.shop.repository.UserRepo
import com.hristijan.draganovski.shop.request.SignUp
import com.hristijan.draganovski.shop.service.UserService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val userRepo: UserRepo, val bCryptPasswordEncoder: BCryptPasswordEncoder) : MongoDbServiceImpl<User>(userRepo), UserService {
    override fun signUp(singUpRequest: SignUp) {
        val user: User = User(
                id = UUID.randomUUID().toString(),
                email = singUpRequest.email,
                password = bCryptPasswordEncoder.encode(singUpRequest.password),
                fullName = singUpRequest.fullName,
                imageUrl = singUpRequest.imageUrl,
                roles = listOf(Role.USER),
                createdOn = Date(),
                modifiedOn = Date()
        )

        userRepo.save(user)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepo.findByEmail(username!!).let { user ->
            org.springframework.security.core.userdetails.User(
                    user.email,
                    user.password,
                    user.roles.map { SimpleGrantedAuthority("$it") })
        }
    }
}