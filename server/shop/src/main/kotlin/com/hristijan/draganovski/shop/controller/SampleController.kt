package com.hristijan.draganovski.shop.controller

import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/samp")
class SampleController {

    @GetMapping
    fun norole(principal: Principal?): Principal? {
        return principal
    }

    @GetMapping("/user")
    fun user(principal: Principal?): Principal?{
        return  principal
    }

    @GetMapping("/admin")
    fun admin(principal: Principal?): Principal?{
        return  principal
    }
}