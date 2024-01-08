package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import java.util.*

interface AdmitPatientFromRequest {
    fun admitPatientFromRequest(requestId: UUID, staffId: String, admissionInfo: PatientAdmissionDto?): Boolean
}
