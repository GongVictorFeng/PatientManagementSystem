package seg3102.pms.domain.division.entities.ward

import java.util.UUID

class Bed(val bedId: String,
    val roomId: String,
    val divisionId: String) {
    var patientId: UUID? = null
    var occupied: Boolean = false

    fun occupy(patientId: UUID){
        occupied = true
        this.patientId = patientId
    }

    fun unoccupy(){
        patientId = null
        occupied = false
    }
}