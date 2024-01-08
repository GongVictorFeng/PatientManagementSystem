package seg3102.pms.application.dtos.queries

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime

data class StaffRegisterDto(
    val employeeNumber: String,
    val name: String,
    val password: String,
    val email: String,
    val divisionId: String,
    val role: String?
)