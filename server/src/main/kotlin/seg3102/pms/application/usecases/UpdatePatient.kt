package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import java.util.*

interface UpdatePatient {
    fun updatePatient(patientInfo: PatientRegisterDto, patientId: UUID, staffId: String): Boolean
}