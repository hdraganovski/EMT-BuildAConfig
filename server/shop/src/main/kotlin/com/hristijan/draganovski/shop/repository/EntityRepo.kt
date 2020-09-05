package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.entities.Entity
import org.springframework.data.mongodb.repository.MongoRepository

interface EntityRepo<T: Entity<K>, K>: MongoRepository<T, String>