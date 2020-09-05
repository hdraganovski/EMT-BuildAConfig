package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.dto.ProductDto
import com.hristijan.draganovski.shop.entities.Product

interface ProductRepo : EntityRepo<Product, ProductDto>