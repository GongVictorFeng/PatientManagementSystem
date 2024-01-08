package seg3102.pms.domain.patient.events

import seg3102.pms.domain.common.DomainEvent
import java.util.*

class PatientUpdated(val id: UUID,
                      val occuredOn: Date,
                      val patientId: UUID): DomainEvent {
}