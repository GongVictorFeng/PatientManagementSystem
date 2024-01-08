package seg3102.pms.infrastructure.mongodb.entities.patient

import seg3102.pms.infrastructure.mongodb.entities.patient.AddressMongoEntity

data class NextOfKinMongoEntity(
    var name: String,
    var relation: String,
    var address: AddressMongoEntity,
    var phoneNum: String
)