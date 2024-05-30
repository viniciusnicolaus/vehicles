package com.fiap.vehicle.application.ports.output

import com.fiap.vehicle.domain.model.Vehicle
import java.util.Optional

interface VehicleRepository {
    fun save(vehicle: Vehicle): Vehicle
    fun findById(id: Long): Optional<Vehicle>
    fun findBySoldTrueOrderByPriceAsc(): List<Vehicle>
    fun findBySoldFalseOrderByPriceAsc(): List<Vehicle>
}
