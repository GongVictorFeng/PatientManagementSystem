package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.RequestCreateDto
import java.util.*

interface RequestPatientAdmission {
    fun requestPatientAdmission(patientId: UUID, divisionId: String, staffId: String, requestInfo: RequestCreateDto): UUID?
}
