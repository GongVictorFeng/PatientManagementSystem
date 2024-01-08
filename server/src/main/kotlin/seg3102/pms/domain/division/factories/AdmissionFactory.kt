package seg3102.pms.domain.division.factories

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.domain.division.entities.Admission

interface AdmissionFactory {
    fun createAdmission(divisionId: String, admissionInfo: PatientAdmissionDto): Admission
}