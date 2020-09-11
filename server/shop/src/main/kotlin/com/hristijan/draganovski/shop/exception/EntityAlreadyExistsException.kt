package com.hristijan.draganovski.shop.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.CONFLICT)
class EntityAlreadyExistsException(entityName: String) : RuntimeException("$entityName already exists")