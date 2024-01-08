package seg3102.pms.infrastructure.mongodb.entities.division


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.util.UUID

@Document(collection = "admissions")
data class AdmissionMongoEntity(
    @Id
    val id: UUID,
    val localDoctor: String,
    val room: String,
    val bed: String,
    val divisionId: String,
    val patientId: UUID,
    val privateInsuranceNum: String?
){
}