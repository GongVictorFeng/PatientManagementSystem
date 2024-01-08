package seg3102.pms.domain.division.events

import seg3102.pms.domain.common.DomainEvent
import java.util.*

class RequestUpdated(
    val id: UUID,
    val occuredOn: Date,
    val requestId: UUID
): DomainEvent
 {
}