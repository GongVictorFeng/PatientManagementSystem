package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.infrastructure.mongodb.entities.PrescriptionMongoEntity

@Mapper
interface PrescriptionMongoConverter {
    fun convertToMongo(prescription: Prescription): PrescriptionMongoEntity

    fun convertToModel(prescriptionMongoEntity: PrescriptionMongoEntity): Prescription
}