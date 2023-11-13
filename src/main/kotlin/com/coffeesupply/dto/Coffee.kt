package com.coffeesupply.dto

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity


@Entity
open class Coffee(
    open var sku: Int = 0,
    open var productName: String = "",
    open var description: String = "",
    open var originCountry: String = "",
    open var price: Double = 0.00

) : PanacheEntity()

