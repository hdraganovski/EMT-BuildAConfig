package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.repository.ProductRepo
import com.hristijan.draganovski.shop.request.CreateProduct
import com.hristijan.draganovski.shop.request.UpdateProduct
import com.hristijan.draganovski.shop.service.ProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(private val productRepo: ProductRepo)
    : MongoDbServiceImpl<Product, ProductDto>(productRepo), ProductService {

    override fun getEntityName(): String = Product::class.java.simpleName

    override fun createProduct(request: CreateProduct): ProductDto {
        val now = Date()
        val product = Product(
                id = UUID.randomUUID().toString(),
                title = request.title,
                description = request.description,
                imageUrls = request.imageUrls,
                price = request.price,
                reviews = listOf(),
                stock = request.stock,
                type = request.type,
                createdOn = now,
                modifiedOn = now
        )

        return product.toDto()
    }

    override fun updateProduct(request: UpdateProduct): ProductDto {
        val product = getById(request.id)
        product.apply {
            title = request.title
            description = request.description
            imageUrls = request.imageUrls
            price = request.price
            reviews = listOf()
            stock = request.stock
            type = request.type
            modifiedOn = Date()
        }

        productRepo.save(product)
        return product.toDto()
    }
}