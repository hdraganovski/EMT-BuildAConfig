package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.dto.UserDto
import com.hristijan.draganovski.shop.request.SignUp
import com.hristijan.draganovski.shop.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @PostMapping
    fun signUp(@RequestBody request: SignUp) {
        userService.signUp(request)
    }

    @GetMapping("/principal")
    fun getPrincipal(principal: Principal): Principal = principal

    @GetMapping("/self")
    fun getSelf(principal: UserDetails): UserDto {
        return userService.getSelf(principal.username)
    }
}