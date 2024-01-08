package seg3102.pms.domain.patient.entities

import seg3102.pms.domain.patient.entities.Address

class NextOfKin (
    var name: String,
    var relation: String,
    var address: Address,
    var phoneNum: String
)