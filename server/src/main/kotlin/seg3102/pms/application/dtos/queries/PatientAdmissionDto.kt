package seg3102.pms.application.dtos.queries

import java.util.UUID

data class PatientAdmissionDto (
        val localDoctor: String,
        val room: String,
        val bed: String,
        val patientId: UUID,
        val privateInsuranceNum: String?
)

