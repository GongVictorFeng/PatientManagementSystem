package seg3102.pms.domain.log.events

import seg3102.pms.domain.common.DomainEvent
import java.util.*

class NewLogAdded(
    val id: UUID,
    val occuredOn: Date,
    val logId: UUID
    ): DomainEvent {
}