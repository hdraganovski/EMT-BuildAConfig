package com.hristijan.draganovski.shop.entities

import java.util.*

interface Entity<T> {
    var id: String
    var createdOn: Date
    var modifiedOn: Date

    fun toDto(): T
}