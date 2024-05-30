package com.fiap.vehicle.application.ports.input

import com.fiap.vehicle.domain.model.Vehicle
import java.util.Optional

interface VehicleService {
    fun registerVehicle(vehicle: Vehicle): Vehicle
    fun updateVehicle(id: Long, vehicle: Vehicle): Vehicle
    fun purchaseVehicle(id: Long, buyerId: Long): Vehicle
    fun listVehicles(sold: Boolean): List<Vehicle>
    fun getVehicleById(id: Long): Optional<Vehicle>
}
