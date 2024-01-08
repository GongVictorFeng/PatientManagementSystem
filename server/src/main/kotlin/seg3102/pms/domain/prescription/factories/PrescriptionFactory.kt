package seg3102.pms.domain.prescription.factories

import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.domain.prescription.entities.Prescription
import java.util.*

interface PrescriptionFactory {
    fun createPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID): Prescription
}