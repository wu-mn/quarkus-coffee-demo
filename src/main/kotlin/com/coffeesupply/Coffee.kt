package com.coffeesupply.dto

import jakarta.persistence.Entity
import jakarta.persistence.Id
import io.quarkus.hibernate.orm.panache.PanacheEntity
import org.hibernate.annotations.JdbcTypeCode

@Entity
open class Coffee(
    open var id: Int = 0,
    open var productName: String = "",
    open var description: String = "",
    open var originCountry: String = "",
    open var price: Double = 0.00
) : PanacheEntity()

