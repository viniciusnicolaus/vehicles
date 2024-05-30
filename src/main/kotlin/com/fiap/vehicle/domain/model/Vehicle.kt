package com.fiap.vehicle.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Vehicle(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var make: String,
    var model: String,
    var vehicleYear: Int,
    var color: String,
    var price: Double,
    var sold: Boolean = false,
    var buyerId: Long? = null
)
