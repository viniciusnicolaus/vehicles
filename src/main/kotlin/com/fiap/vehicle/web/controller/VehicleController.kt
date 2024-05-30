package com.fiap.vehicle.web.controller

import com.fiap.vehicle.application.ports.input.VehicleService
import com.fiap.vehicle.domain.model.Vehicle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/vehicles")
class VehicleController(private val vehicleService: VehicleService) {

    @PostMapping
    fun registerVehicle(@RequestBody vehicle: Vehicle): Vehicle {
        return vehicleService.registerVehicle(vehicle)
    }

    @PutMapping("/{id}")
    fun updateVehicle(@PathVariable id: Long, @RequestBody vehicle: Vehicle): Vehicle {
        return vehicleService.updateVehicle(id, vehicle)
    }

    @PostMapping("/{id}/purchase")
    fun purchaseVehicle(@PathVariable id: Long, @RequestParam buyerId: Long): Vehicle {
        return vehicleService.purchaseVehicle(id, buyerId)
    }

    @GetMapping
    fun listVehicles(@RequestParam sold: Boolean = false): List<Vehicle> {
        return vehicleService.listVehicles(sold)
    }

    @GetMapping("/{id}")
    fun getVehicleById(@PathVariable id: Long): Optional<Vehicle> {
        return vehicleService.getVehicleById(id)
    }
}
