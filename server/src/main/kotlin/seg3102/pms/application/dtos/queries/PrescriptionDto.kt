package seg3102.pms.application.dtos.queries

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalDate
import java.util.UUID

data class PrescriptionDto(
    val drugNum: String,
    val drugName: String,
    val unitsByDay: String,
    val numAdminPerDay: Int,
    val administrationTimes: List<String>,
    val methodOfAdministration: String,
    val startDate: String,
    val finishDate: String
)
