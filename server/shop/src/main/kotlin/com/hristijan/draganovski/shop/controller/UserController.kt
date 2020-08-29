package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.request.SignUp
import com.hristijan.draganovski.shop.service.UserService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @PostMapping
    fun signUp(@RequestBody request: SignUp) {
        userService.signUp(request)
    }

    @GetMapping
    fun getSelf() {

    }
}