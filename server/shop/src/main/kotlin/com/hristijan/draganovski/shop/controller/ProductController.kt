package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.dto.Message
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.request.CreateProduct
import com.hristijan.draganovski.shop.request.UpdateProduct
import com.hristijan.draganovski.shop.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(private val productService: ProductService): BaseController<Product>(productService) {
    @GetMapping
    override fun getAll(@RequestParam params: Map<String, String>): Page<Product> {
        return super.getAll(params)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Product? {
        return super.getById(id)
    }

    @PostMapping
    fun post(@RequestBody request: CreateProduct): Product {
        return productService.createProduct(request)
    }

    @PutMapping
    fun put(@RequestBody request: UpdateProduct): Product {
        return productService.updateProduct(request)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Message {
        productService.delete(id)
        return Message("OK")
    }

}