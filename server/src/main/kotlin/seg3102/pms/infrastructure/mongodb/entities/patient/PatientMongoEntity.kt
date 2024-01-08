package seg3102.pms.infrastructure.mongodb.entities.patient

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import seg3102.pms.infrastructure.mongodb.entities.patient.AddressMongoEntity

import java.time.LocalDate
import java.util.UUID

@Document(collection = "patient")
data class PatientMongoEntity(
    @Id val id: UUID,
    var insuranceNum: Int,
    var firstName: String,
    var lastName: String,
    var address: AddressMongoEntity,
    var phoneNum: String,
    var dateOfBirth: String,
    var gender: String,
    var martialStatus: String,
    var famDoctor: String,
    var nextOfKin: NextOfKinMongoEntity,
)