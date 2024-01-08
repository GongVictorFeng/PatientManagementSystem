package seg3102.pms.domain.log.entities

import java.time.LocalDateTime
import java.util.UUID

class Log(val id: UUID,
    val operation: String,
    val time: LocalDateTime) {
    var staff: String? = null
    var patient: UUID? = null
    var prescription: UUID? = null
}