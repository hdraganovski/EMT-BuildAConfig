package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.repository.ProductRepo
import com.hristijan.draganovski.shop.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepo: ProductRepo)
    : MongoDbServiceImpl<Product>(productRepo), ProductService {

    override fun getEntityName(): String = Product::class.java.simpleName
}