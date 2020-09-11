package com.hristijan.draganovski.shop.entities

import com.hristijan.draganovski.shop.dto.CategoryDto
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document(collection = "category")
data class Category(
        override var id: String,
        @Indexed var name: String,
        var imageUrl: String,
        override var createdOn: Date,
        override var modifiedOn: Date,
        var deletedOn: Date?
        ) : Entity<CategoryDto> {
    override fun toDto(): CategoryDto {
        return CategoryDto(id, name, imageUrl)
    }
}