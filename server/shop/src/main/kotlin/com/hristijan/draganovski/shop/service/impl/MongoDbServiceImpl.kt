package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.entities.Entity
import com.hristijan.draganovski.shop.repository.EntityRepo
import com.hristijan.draganovski.shop.service.MongoDbService
import org.bson.types.ObjectId
import org.springframework.data.domain.Sort

open class MongoDbServiceImpl<T : Entity>(val repo: EntityRepo<T>): MongoDbService<T> {
    override fun getAll(): List<T> =
            repo.findAll()

    override fun getById(id: String): T? =
            repo.findById(id).let {
                if (it.isPresent)
                    it.get()
                else
                    null
            }

    override fun sortedByCreatedOn(): List<T> {
        return repo.findAll(Sort.by("createdOn"))
    }
}