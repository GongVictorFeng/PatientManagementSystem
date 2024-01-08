package seg3102.pms.domain.patient.factories

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.entities.Patient

interface PatientFactory {
    fun createPatient(patientInfo: PatientRegisterDto): Patient
}