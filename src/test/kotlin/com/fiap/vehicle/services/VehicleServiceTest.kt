import com.fiap.vehicle.VehiclesApplication
import com.fiap.vehicle.application.ports.input.VehicleService
import com.fiap.vehicle.application.ports.output.VehicleRepository
import com.fiap.vehicle.application.services.VehicleServiceImpl
import com.fiap.vehicle.domain.model.Vehicle
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*


@ActiveProfiles("test")
@SpringBootTest(classes = [VehiclesApplication::class])
class VehicleServiceTest {

    private val vehicleRepository: VehicleRepository = mockk()
    private val vehicleService: VehicleService = VehicleServiceImpl(vehicleRepository)

    @Test
    fun `should return all vehicles for sale`() {
        // Given
        val vehicles = listOf(
            Vehicle(make = "Toyota", model = "Corolla", vehicleYear = 2022, color = "White", price = 87000.00, sold = false),
            Vehicle(make = "Honda", model = "Civic", vehicleYear = 2021, color = "Black", price = 92000.00, sold = false)
        )
        every { vehicleRepository.findBySoldFalseOrderByPriceAsc() } returns vehicles

        // When
        val result = vehicleService.listVehicles(false)

        // Then
        assertEquals(2, result.size)
        verify { vehicleRepository.findBySoldFalseOrderByPriceAsc() }
    }

    @Test
    fun `should return all sold vehicles`() {
        // Given
        val vehicles = listOf(
            Vehicle(make = "Toyota", model = "Corolla", vehicleYear = 2022, color = "White", price = 87000.00, sold = true),
            Vehicle(make = "Honda", model = "Civic", vehicleYear = 2021, color = "Black", price = 92000.00, sold = true)
        )
        every { vehicleRepository.findBySoldTrueOrderByPriceAsc() } returns vehicles

        // When
        val result = vehicleService.listVehicles(true)

        // Then
        assertEquals(2, result.size)
        verify { vehicleRepository.findBySoldTrueOrderByPriceAsc() }
    }

    @Test
    fun `should find vehicle by id`() {
        // Given
        val vehicle = Vehicle(make = "Toyota", model = "Corolla", vehicleYear = 2022, color = "White", price = 87000.00, sold = false)
        every { vehicleRepository.findById(1L) } returns Optional.of(vehicle)

        // When
        val result = vehicleService.getVehicleById(1L)

        // Then
        assertTrue(result.isPresent)
        assertEquals(vehicle, result.get())
        verify { vehicleRepository.findById(1L) }
    }
}
