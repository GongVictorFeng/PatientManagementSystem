package seg3102.pms.application.dtos.queries

import seg3102.pms.domain.patient.entities.Address

import java.time.LocalDateTime

data class PatientRegisterDto(
        val insuranceNum: Int,
        val firstName: String,
        val lastName: String,
        // val address: Address,
        val street: String,
        val city: String,
        val country: String,
        val postalCode: String,
        val phoneNum: String,
        val dateOfBirth: String,
        val gender: String,
        val martialStatus: String,
        val famDoctor: String,
        val nokName: String,
        val nokRelation: String,
        val nokStreet: String,
        val nokCity: String,
        val nokCountry: String,
        val nokPostalCode: String,
        val nokPhoneNum: String
) {
    // var nextOfKin: NextOfKinCreateDto? = null
}
