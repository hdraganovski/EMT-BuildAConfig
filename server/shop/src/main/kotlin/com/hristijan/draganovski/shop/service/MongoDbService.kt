package com.hristijan.draganovski.shop.service

import com.hristijan.draganovski.shop.entities.Entity
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface MongoDbService<T : Entity<K>, K> {
    fun getAll(): List<K>
    fun getById(id: String): T
    fun getByIdDto(id: String): K
    fun sortedByCreatedOn(): List<K>
    fun getPage(pageable: Pageable): Page<K>
    fun save(entity: T): K
    fun update(entity: T): K
    fun delete(entity: T)
    fun delete(id: String)
    fun getEntityName(): String
}