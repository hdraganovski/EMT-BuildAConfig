package com.hristijan.draganovski.shop.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class EmailAlreadyUsedException() : RuntimeException("Email already used.")