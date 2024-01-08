package seg3102.pms.domain.patient.entities

import seg3102.pms.domain.patient.entities.Address
import seg3102.pms.domain.patient.entities.NextOfKin

import java.time.LocalDate
import java.util.*

class Patient(
    val id: UUID,
    var insuranceNum: Int,
    var firstName: String,
    var lastName: String,
    var address: Address,
    var phoneNum: String,
    var dateOfBirth: LocalDate,
    var gender: String,
    var martialStatus: String,
    var famDoctor: String,
    var nextOfKin: NextOfKin
)
{

    fun update(updated: Patient) {
        insuranceNum = updated.insuranceNum
        firstName = updated.firstName
        lastName = updated.lastName
        address = updated.address
        phoneNum = updated.phoneNum
        dateOfBirth = updated.dateOfBirth
        gender = updated.gender
        martialStatus = updated.martialStatus
        famDoctor = updated.famDoctor
        nextOfKin = updated.nextOfKin
    }


}