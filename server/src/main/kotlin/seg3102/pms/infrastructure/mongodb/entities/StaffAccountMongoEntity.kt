package seg3102.pms.infrastructure.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import seg3102.pms.domain.staff.entities.StaffRole

@Document(collection = "staff")
class StaffAccountMongoEntity(
    @Id
    val employeeNumber: String,
    var name: String,
    var password: String,
    var email: String,
    var divisionId: String
) {
    var role: StaffRole? = null
}