package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import java.util.*

interface DischargePatient {
    fun dischargePatient(divisionId: String, patientId: UUID):Boolean
}
