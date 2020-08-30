package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.entities.Product
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
}