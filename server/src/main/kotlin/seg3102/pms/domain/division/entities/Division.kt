package seg3102.pms.domain.division.entities

import java.util.UUID

class Division(val divisionId: String,
    var divisionName:String,
    var chargeNurseId:String,
    var location:String,
    var bedNum:Int,
    var occupiedBedNum: Int,
    val extensionNum:String,
    ) {
    var complete: Boolean = false

    fun updateDischarge() {
        if(occupiedBedNum == bedNum){
            complete = false
        }
        occupiedBedNum--;
    }

    fun updateAdmission(){
        occupiedBedNum++
        complete = bedNum == occupiedBedNum
    }

    fun isUnderChargeOf(staffId: String): Boolean {
        return chargeNurseId == staffId
    }
}
