package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.infrastructure.mongodb.entities.division.AdmissionMongoEntity

@Mapper
interface AdmissionMongoConverter {
    fun convertToMongo(admission: Admission): AdmissionMongoEntity
    fun convertToModel(admissionMongoEntity: AdmissionMongoEntity): Admission
    fun convertListToModels(admissionMongoEntities: List<AdmissionMongoEntity>): List<Admission>
}
