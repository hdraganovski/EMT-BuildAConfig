package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.entities.Entity
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface MongoDbService<T : Entity> {
    fun getAll(): List<T>
    fun getById(id: String): T
    fun sortedByCreatedOn(): List<T>
    fun getPage(pageable: Pageable): Page<T>
    fun save(entity: T): T
    fun update(entity: T): T
    fun delete(entity: T)
    fun delete(id: String)
    fun getEntityName(): String
}