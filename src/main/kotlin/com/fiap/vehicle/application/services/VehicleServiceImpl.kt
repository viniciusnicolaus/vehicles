package com.fiap.vehicle.application.services

import com.fiap.vehicle.application.ports.input.VehicleService
import com.fiap.vehicle.application.ports.output.VehicleRepository
import com.fiap.vehicle.domain.model.Vehicle
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class VehicleServiceImpl(private val vehicleRepository: VehicleRepository) : VehicleService {

    override fun registerVehicle(vehicle: Vehicle): Vehicle {
        return vehicleRepository.save(vehicle)
    }

    override fun updateVehicle(id: Long, vehicle: Vehicle): Vehicle {
        val existingVehicle = vehicleRepository.findById(id).orElseThrow { Exception("Vehicle not found") }
        existingVehicle.apply {
            make = vehicle.make
            model = vehicle.model
            vehicleYear = vehicle.vehicleYear
            price = vehicle.price
            sold = vehicle.sold
            color = vehicle.color
        }
        return vehicleRepository.save(existingVehicle)
    }

    override fun purchaseVehicle(id: Long, buyerId: Long): Vehicle {
        val vehicle = vehicleRepository.findById(id).orElseThrow { Exception("Vehicle not found") }
        vehicle.sold = true
        vehicle.buyerId = buyerId
        return vehicleRepository.save(vehicle)
    }

    override fun listVehicles(sold: Boolean): List<Vehicle> {
        return if (sold) {
            vehicleRepository.findBySoldTrueOrderByPriceAsc()
        } else {
            vehicleRepository.findBySoldFalseOrderByPriceAsc()
        }
    }

    override fun getVehicleById(id: Long): Optional<Vehicle> {
        return vehicleRepository.findById(id)
    }
}
