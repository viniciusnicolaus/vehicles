package com.fiap.vehicle.infrastructure.adapters

import com.fiap.vehicle.application.ports.output.VehicleRepository
import com.fiap.vehicle.domain.model.Vehicle
import com.fiap.vehicle.infrastructure.persistence.VehicleJpaRepository
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class VehicleRepositoryAdapter(private val vehicleJpaRepository: VehicleJpaRepository) : VehicleRepository {
    override fun save(vehicle: Vehicle): Vehicle {
        return vehicleJpaRepository.save(vehicle)
    }

    override fun findById(id: Long): Optional<Vehicle> {
        return vehicleJpaRepository.findById(id)
    }

    override fun findBySoldTrueOrderByPriceAsc(): List<Vehicle> {
        return vehicleJpaRepository.findBySoldTrueOrderByPriceAsc()
    }

    override fun findBySoldFalseOrderByPriceAsc(): List<Vehicle> {
        return vehicleJpaRepository.findBySoldFalseOrderByPriceAsc()
    }
}
