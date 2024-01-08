package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.responses.PatientFileDto
import java.util.*

interface ConsultPatientFile {
    fun findPatient(patientId: UUID, staffId: String): PatientFileDto?
}
