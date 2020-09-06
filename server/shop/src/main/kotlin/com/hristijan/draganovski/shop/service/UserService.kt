package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.UserDto
import com.hristijan.draganovski.shop.entities.Cart
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.entities.Role
import com.hristijan.draganovski.shop.entities.User
import com.hristijan.draganovski.shop.exception.EmailAlreadyUsedException
import com.hristijan.draganovski.shop.repository.UserRepo
import com.hristijan.draganovski.shop.request.SignUp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

interface UserService: MongoDbService<User, UserDto>, UserDetailsService {
    fun signUp(singUpRequest: SignUp)
    fun getSelf(email: String): UserDto
}

@Service
class UserServiceImpl(private val userRepo: UserRepo, val bCryptPasswordEncoder: BCryptPasswordEncoder) : MongoDbServiceImpl<User, UserDto>(userRepo), UserService {
    override fun signUp(singUpRequest: SignUp) {
        val exists = userRepo.existsByEmail(singUpRequest.email)

        if(exists) {
            throw EmailAlreadyUsedException()
        }

        val user = User(
                id = "",
                email = singUpRequest.email,
                password = bCryptPasswordEncoder.encode(singUpRequest.password),
                fullName = singUpRequest.fullName,
                imageUrl = singUpRequest.imageUrl,
                roles = listOf(Role.USER),
                cart = Cart(
                        id = UUID.randomUUID().toString(),
                        products = listOf(),
                        createdOn = Date(),
                        modifiedOn = Date()
                ),
                configurations = listOf(),
                purchases = listOf(),
                createdOn = Date(),
                modifiedOn = Date(),
                deletedOn = null)

        super.save(user)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepo.findByEmail(username!!).let { user ->
            org.springframework.security.core.userdetails.User(
                    user.email,
                    user.password,
                    user.roles.map { SimpleGrantedAuthority("$it") })
        }
    }

    override fun getSelf(email: String): UserDto {
        return userRepo.findByEmail(email).toDto()
    }

    override fun getEntityName(): String = Product::class.java.simpleName
}