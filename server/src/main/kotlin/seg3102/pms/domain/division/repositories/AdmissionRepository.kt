package seg3102.pms.domain.division.repositories

import seg3102.pms.domain.division.entities.Admission
import java.util.UUID

interface AdmissionRepository {
    fun save(admission: Admission):Admission
    fun find(id: UUID): Admission?
    fun findByDivisionId(divisionId: String): List<Admission>
    fun findByPatientId(patientId: UUID): Admission?

    fun deleteByPatientId(patientId: UUID)
}