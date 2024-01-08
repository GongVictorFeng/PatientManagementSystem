package seg3102.pms.domain.patient.repositories

import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.application.dtos.queries.PatientRegisterDto
import java.util.*

interface PatientRepository {
    fun save(patient: Patient): Patient
    fun find(patient: PatientRegisterDto): Patient?
    fun find(id: UUID): Patient?

}