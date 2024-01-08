package seg3102.pms.infrastructure.mongodb.entities.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.util.UUID

@Document(collection = "divisions")
data class DivisionMongoEntity(
    @Id val divisionId: String,
    var divisionName:String,
    var chargeNurseId:String,
    var location:String,
    var bedNum:Int,
    var occupiedBedNum: Int,
    val extensionNum:String,
) {
    var complete: Boolean = false
}