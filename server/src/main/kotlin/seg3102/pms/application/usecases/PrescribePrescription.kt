package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PrescriptionDto
import java.util.*

interface PrescribePrescription {
    fun addPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID, employeeNumber: String): UUID?
}