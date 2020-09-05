package com.hristijan.draganovski.shop.service.impl

import com.hristijan.draganovski.shop.entities.Entity
import com.hristijan.draganovski.shop.exception.NotFoundException
import com.hristijan.draganovski.shop.repository.EntityRepo
import com.hristijan.draganovski.shop.service.MongoDbService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

abstract class MongoDbServiceImpl<T : Entity<K>, K>(val repo: EntityRepo<T, K>) : MongoDbService<T, K> {
    override fun getAll(): List<K> =
            repo.findAll().map { it.toDto() }

    override fun getById(id: String): T =
            repo.findById(id).let {
                if (it.isPresent)
                    it.get()
                else
                    throw NotFoundException("${getEntityName()} not found.")
            }

    override fun getByIdDot(id: String): K {
      return getById(id).toDto()
    }

    override fun sortedByCreatedOn(): List<K> {
        return repo.findAll(Sort.by("createdOn")).map { it.toDto() }
    }

    override fun getPage(pageable: Pageable): Page<K> {
        return repo.findAll(pageable).let { page ->
            PageImpl<K>(
                    page.content.map { it.toDto() },
                    page.pageable,
                    page.totalElements
            )
        }
    }

    override fun save(entity: T): K {
        entity.id = UUID.randomUUID().toString()
        entity.createdOn = Date()
        entity.modifiedOn = entity.createdOn

        return repo.save(entity).toDto()
    }

    override fun update(entity: T): K {
        entity.modifiedOn = Date()

        return repo.save(entity).toDto()
    }

    override fun delete(entity: T) {
        return repo.delete(entity)
    }

    override fun delete(id: String) {
        return repo.deleteById(id)
    }
}