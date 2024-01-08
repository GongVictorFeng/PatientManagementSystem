package seg3102.pms.application.dtos.responses

import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.entities.Request

data class VisualizeDivisionDto (
    val divisionId: String,
    var divisionName:String,
    var chargeNurseId:String,
    var location:String,
    var bedNum:Int,
    var occupiedBedNum: Int,
    val extensionNum:String,
    val beds: List<Bed>,
    val admissions: List<Admission>,
    val requests: List<Request>
)