package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.exception.InvalidRequestException
import com.hristijan.draganovski.shop.repository.CategoryRepo
import com.hristijan.draganovski.shop.repository.ProductRepo
import com.hristijan.draganovski.shop.request.ProductRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

interface ProductService : MongoDbService<Product, ProductDto> {
    fun createProduct(request: ProductRequest): ProductDto
    fun updateProduct(request: ProductRequest, id: String): ProductDto
    fun getPageByCategory(category: String, pageable: Pageable): Page<ProductDto>
}

@Service
class ProductServiceImpl(private val productRepo: ProductRepo, private val categoryRepo: CategoryRepo)
    : MongoDbServiceImpl<Product, ProductDto>(productRepo), ProductService {

    override fun getEntityName(): String = Product::class.java.simpleName

    override fun getPageByCategory(category: String, pageable: Pageable): Page<ProductDto> {
        return productRepo.findByCategory(category, pageable).mapTo { it.toDto() }
    }

    override fun createProduct(request: ProductRequest): ProductDto {
        val exists = categoryRepo.existsByName(request.category)

        if (!exists) {
            throw InvalidRequestException("Category doesnt exist")
        }

        val now = Date()
        val product = Product(
                id = UUID.randomUUID().toString(),
                title = request.title,
                description = request.description,
                imageUrls = request.imageUrls,
                price = request.price,
                reviews = listOf(),
                stock = request.stock,
                category = request.category,
                createdOn = now,
                modifiedOn = now,
                deletedOn = null
        )

        return super.save(product)
    }

    override fun updateProduct(request: ProductRequest, id: String): ProductDto {
        val product = getById(id)
        product.apply {
            title = request.title
            description = request.description
            imageUrls = request.imageUrls
            price = request.price
            reviews = listOf()
            stock = request.stock
            category = request.category
            modifiedOn = Date()
        }

        return super.update(product)
    }
}