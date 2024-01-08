package seg3102.pms.application.dtos.responses

data class PatientFileDto (
    var insuranceNum: Int,
    var firstName: String,
    var lastName: String,
    var street: String,
    var city: String,
    var country: String,
    var postalCode: String,
    var phoneNum: String,
    var dateOfBirth: String,
    var gender: String,
    var martialStatus: String,
    var famDoctor: String,
    var nokName: String,
    var nokRelation: String,
    var nokStreet: String,
    var nokCity: String,
    var nokCountry: String,
    var nokPostalCode: String,
    var nokPhoneNum: String,
)