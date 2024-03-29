package seg3102.pms.domain.prescription.repositories

import seg3102.pms.domain.prescription.entities.Prescription
import java.util.*

interface PrescriptionRepository {
    fun save(prescription: Prescription): Prescription
    fun find(id: UUID): Prescription?

    fun findAllByPatientId(patientId: UUID): List<Prescription>
}
