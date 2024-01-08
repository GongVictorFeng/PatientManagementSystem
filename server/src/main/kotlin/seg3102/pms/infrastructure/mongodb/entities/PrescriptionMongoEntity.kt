package seg3102.pms.infrastructure.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document(collection = "prescription")
class PrescriptionMongoEntity(
    @Id
    val id: UUID,
    val patientId: UUID,
    val drugNum: String,
    val drugName: String,
    val unitsByDay: String,
    val numAdminPerDay: Int,
    val administrationTimes: List<String>,
    val methodOfAdministration: String,
    val startDate: String,
    val finishDate: String
) {
}