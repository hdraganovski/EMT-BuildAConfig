package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.entities.Entity
import com.hristijan.draganovski.shop.exception.NotFoundException
import com.hristijan.draganovski.shop.repository.EntityRepo
import com.hristijan.draganovski.shop.service.MongoDbService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

abstract class MongoDbServiceImpl<T : Entity>(val repo: EntityRepo<T>): MongoDbService<T> {
    override fun getAll(): List<T> =
            repo.findAll()

    override fun getById(id: String): T =
            repo.findById(id).let {
                if (it.isPresent)
                    it.get()
                else
                    throw NotFoundException("${getEntityName()} not found.")
            }

    override fun sortedByCreatedOn(): List<T> {
        return repo.findAll(Sort.by("createdOn"))
    }

    override fun getPage(pageable: Pageable): Page<T> {
        return repo.findAll(pageable)
    }

    override fun save(entity: T): T {
        entity.id = UUID.randomUUID().toString()
        entity.createdOn = Date()
        entity.modifiedOn = entity.createdOn

        return repo.save(entity)
    }

    override fun update(entity: T): T {
        entity.modifiedOn = Date()

        return repo.save(entity)
    }

    override fun delete(entity: T) {
        return repo.delete(entity)
    }

    override fun delete(id: String) {
        return repo.deleteById(id)
    }
}