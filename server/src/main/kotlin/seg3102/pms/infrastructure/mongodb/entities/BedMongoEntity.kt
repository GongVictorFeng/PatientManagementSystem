package seg3102.pms.infrastructure.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "bed")
class BedMongoEntity(
    val bedId: String,
    val roomId: String,
    val divisionId: String
) {
    var patientId: UUID? = null
    var occupied: Boolean = false
}