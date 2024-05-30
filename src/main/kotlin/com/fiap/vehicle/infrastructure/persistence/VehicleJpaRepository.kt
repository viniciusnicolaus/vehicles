package com.fiap.vehicle.infrastructure.persistence

import com.fiap.vehicle.domain.model.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface VehicleJpaRepository : JpaRepository<Vehicle, Long> {
    fun findBySoldTrueOrderByPriceAsc(): List<Vehicle>
    fun findBySoldFalseOrderByPriceAsc(): List<Vehicle>
    override fun findById(id: Long): Optional<Vehicle>
}
