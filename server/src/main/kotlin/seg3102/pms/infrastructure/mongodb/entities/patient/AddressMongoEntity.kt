package seg3102.pms.infrastructure.mongodb.entities.patient

data class AddressMongoEntity(
    var street: String,
    var city: String,
    var country: String,
    var postalCode: String
)