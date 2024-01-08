package seg3102.pms.domain.prescription.entities

import java.time.LocalDate
import java.util.*

class Prescription(
    val id: UUID,
    val patientId: UUID,
    val drugNum: String,
    val drugName: String,
    val unitsByDay: String,
    val numAdminPerDay: Int,
    val administrationTimes: List<String>,
    val methodOfAdministration: String,
    val startDate: LocalDate,
    val finishDate: LocalDate
) {}