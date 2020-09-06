package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.UserDto
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "user")
data class User(
        override var id: String,
        @Indexed var email: String,
        var password: String,
        var fullName: String,
        var imageUrl: String,
        var roles: List<Role>,
        var cart: Cart,
        var purchases: List<Purchase>,
        var configurations: List<Configuration>,
        override var createdOn: Date,
        override var modifiedOn: Date,
        var deletedOn: Date?
) : Entity<UserDto> {
    override fun toDto(): UserDto {
        return UserDto(
                id,
                email,
                fullName,
                imageUrl,
                cart.toDto(),
                purchases.map { it.toDto() },
                configurations.map { it.toDto() }
        )
    }
}