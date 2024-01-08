package seg3102.pms.domain.division.entities

import java.util.UUID

class Admission(
    val id: UUID,
    val localDoctor: String,
    val room: String,
    val bed: String,
    val divisionId: String,
    val patientId: UUID,
) {
    var privateInsuranceNum: String? = null
}