package com.hristijan.draganovski.shop.controller

import com.hristijan.draganovski.shop.entities.Entity
import com.hristijan.draganovski.shop.service.MongoDbService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

abstract class PageableController<T : Entity<K>, K>(private val service: MongoDbService<T, K>) {
    open fun getPage(params: Map<String, String>): Page<K> {
        val pageQuery = getPageQuery(params)
        return service.getPage(pageQuery)
    }

    private fun getPageQuery(params: Map<String, String>): Pageable {
        val sort = if (params.containsKey(PARAM_KEY_SORT)) Sort.by(params[PARAM_KEY_SORT]) else Sort.unsorted()

        return PageRequest.of(
                params.getOrDefault(PARAM_KEY_PAGE, "$START_PAGE").toInt(),
                params.getOrDefault(PARAM_KEY_SIZE, "$DEFAULT_SIZE").toInt(),
                sort)
    }

    companion object {
        const val PARAM_KEY_PAGE = "page"
        const val PARAM_KEY_SIZE = "size"
        const val PARAM_KEY_SORT = "sort"

        const val START_PAGE = 0
        const val DEFAULT_SIZE = 32
    }
}

