package seg3102.pms.domain.patient.facade

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.entities.Patient
import java.math.BigDecimal
import java.util.*

interface PatientFacade {
    fun findPatient(patientId: UUID): Patient?
    fun registerPatient(patientInfo: PatientRegisterDto): UUID
    fun checkExistingPatient(patientInfo: PatientRegisterDto): Boolean
    fun updatePatient(patientId: UUID, patientInfo: PatientRegisterDto): Boolean

}