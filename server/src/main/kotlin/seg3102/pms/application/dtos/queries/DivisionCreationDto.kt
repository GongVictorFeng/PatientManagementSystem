package seg3102.pms.application.dtos.queries

data class DivisionCreationDto(
    val divisionId: String,
    var divisionName:String,
    var chargeNurseId:String,
    var location:String,
    var bedNum:Int,
    var occupiedBedNum: Int,
    val extensionNum:String,
) {
}