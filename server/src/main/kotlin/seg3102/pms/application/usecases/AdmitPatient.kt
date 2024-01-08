package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import java.util.*

interface AdmitPatient {
    fun addPatient(divisionId: String, admissionInfo: PatientAdmissionDto): Boolean
}