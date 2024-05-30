package com.fiap.vehicle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.fiap.vehicle.infrastructure.persistence"])
class VehiclesApplication

fun main(args: Array<String>) {
	runApplication<VehiclesApplication>(*args)
}
