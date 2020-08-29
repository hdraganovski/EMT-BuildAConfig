package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.entities.Entity
import org.bson.types.ObjectId

interface MongoDbService<T : Entity> {
    fun getAll(): List<T>
    fun getById(id: String): T?
    fun sortedByCreatedOn(): List<T>
}