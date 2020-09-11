package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.dto.Message
import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product
import com.hristijan.draganovski.shop.request.ProductRequest
import com.hristijan.draganovski.shop.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(private val productService: ProductService): PageableController<Product, ProductDto>(productService) {
    @GetMapping
    override fun getPage(@RequestParam params: Map<String, String>): Page<ProductDto> {
        return super.getPage(params)
    }

    @GetMapping("/category/{category}")
    fun getFromCategory(@RequestParam params: Map<String, String>): Page<ProductDto> {
        val q = getPageQuery(params)
        return productService.getPage(q)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): ProductDto {
        return productService.getByIdDto(id)
    }

    @PostMapping
    fun post(@RequestBody request: ProductRequest): ProductDto {
        return productService.createProduct(request)
    }

    @PutMapping("/{id}")
    fun put(@RequestBody request: ProductRequest, @PathVariable id: String): ProductDto {
        return productService.updateProduct(request, id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Message {
        productService.delete(id)
        return Message("OK")
    }
}