package seg3102.pms.domain.prescription.events

import seg3102.pms.domain.common.DomainEvent
import java.util.*

class NewPrescriptionAdded(
    val id: UUID,
    val occuredOn: Date,
    val prescriptionId: UUID
): DomainEvent {}
