package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.CategoryDto
import com.hristijan.draganovski.shop.entities.Category
import com.hristijan.draganovski.shop.repository.CategoryRepo
import com.hristijan.draganovski.shop.request.CategoryRequest
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.util.*

interface CategoryService : MongoDbService<Category, CategoryDto> {
    fun createCategory(request: CategoryRequest): CategoryDto
    fun updateCategory(request: CategoryRequest, id: String): CategoryDto
}

@Service
class CategoryServiceImpl(private val categoryRepo: CategoryRepo)
    : MongoDbServiceImpl<Category, CategoryDto>(categoryRepo), CategoryService {

    override fun getEntityName(): String {
        return Category::class.java.simpleName
    }

    override fun createCategory(request: CategoryRequest): CategoryDto {
        val now = Date()
        val category = Category(
                UUID.randomUUID().toString(),
                request.name,
                request.imageUrl,
                now,
                now,
                null
        )
        save(category)
        return category.toDto();
    }

    override fun updateCategory(request: CategoryRequest, id: String): CategoryDto {
        val category = getById(id)

        category.apply {
            name = request.name
            imageUrl = request.imageUrl
        }
        update(category)

        return category.toDto()
    }

    override fun delete(entity: Category) {
        entity.deletedOn = Date()
        update(entity)
    }

    override fun getAll(): List<CategoryDto> {
        return categoryRepo.findByDeletedOnIsNull().map { it.toDto() }
    }
}