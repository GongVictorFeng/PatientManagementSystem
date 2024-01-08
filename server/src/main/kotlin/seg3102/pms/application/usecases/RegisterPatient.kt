package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import java.util.*

interface RegisterPatient {
    fun registerPatient(patientInfo: PatientRegisterDto): UUID?
}