package seg3102.pms.domain.staff.events

import seg3102.pms.domain.common.DomainEvent
import java.util.*

class NewStaffRegistered(val id: UUID,
                      val occuredOn: Date,
                      val staffId: String): DomainEvent {
}