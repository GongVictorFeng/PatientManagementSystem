package seg3102.pms.infrastructure.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document(collection = "log")
class LogMongoEntity (
    @Id
    val id: UUID,
    val operation: String,
    val time: LocalDateTime
){
    var staff: String? = null
    var patient: UUID? = null
    var prescription: UUID? = null
}