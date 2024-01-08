package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.entities.Address
import seg3102.pms.domain.patient.entities.NextOfKin
import seg3102.pms.infrastructure.mongodb.entities.patient.PatientMongoEntity
import seg3102.pms.infrastructure.mongodb.entities.patient.AddressMongoEntity
import seg3102.pms.infrastructure.mongodb.entities.patient.NextOfKinMongoEntity

@Mapper
interface PatientMongoConverter {
    fun convertToMongo(patient: Patient): PatientMongoEntity
    
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    fun convertToModel(patientMongo: PatientMongoEntity): Patient

    fun convertAddressToMongo(address: Address): AddressMongoEntity
    fun convertAddressToModel(addressMongo: AddressMongoEntity): Address

    fun convertNextOfKinToMongo(nextofkin: NextOfKin): NextOfKinMongoEntity
    fun convertNextOfKinToModel(nextofkinMongo: NextOfKinMongoEntity): NextOfKin
}