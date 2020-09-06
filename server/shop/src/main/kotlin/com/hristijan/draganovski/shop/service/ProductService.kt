package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.repository.ProductRepo
import com.hristijan.draganovski.shop.request.ProductRequest
import org.springframework.stereotype.Service
import java.util.*

interface ProductService : MongoDbService<Product, ProductDto> {
    fun createProduct(request: ProductRequest): ProductDto
    fun updateProduct(request: ProductRequest, id: String): ProductDto
}

@Service
class ProductServiceImpl(private val productRepo: ProductRepo)
    : MongoDbServiceImpl<Product, ProductDto>(productRepo), ProductService {

    override fun getEntityName(): String = Product::class.java.simpleName

    override fun createProduct(request: ProductRequest): ProductDto {
        val now = Date()
        val product = Product(
                id = UUID.randomUUID().toString(),
                title = request.title,
                description = request.description,
                imageUrls = request.imageUrls,
                price = request.price,
                reviews = listOf(),
                stock = request.stock,
                categoryId = request.categoryId,
                createdOn = now,
                modifiedOn = now,
                deletedOn = null
        )

        return product.toDto()
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
            categoryId = request.categoryId
            modifiedOn = Date()
        }

        productRepo.save(product)
        return product.toDto()
    }

    override fun delete(entity: Product) {
        entity.deletedOn = Date()
        repo.save(entity)
    }
}