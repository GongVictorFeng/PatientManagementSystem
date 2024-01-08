package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component
import org.springframework.data.repository.findByIdOrNull

import seg3102.pms.adapters.repositories.converters.AdmissionMongoConverter
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.repositories.AdmissionRepository
import seg3102.pms.infrastructure.mongodb.dao.AdmissionMongoRepository
import seg3102.pms.infrastructure.mongodb.entities.division.AdmissionMongoEntity

import java.util.UUID

@Component
class AdmissionMongoAdapter(private val admissionRepository: AdmissionMongoRepository): AdmissionRepository {
    private val converter = Mappers.getMapper(AdmissionMongoConverter::class.java)

    override fun save(admission: Admission): Admission {
        val admissionMongo = converter.convertToMongo(admission)
        admissionRepository.save(admissionMongo)
        return admission
    }

    override fun find(id: UUID): Admission? {
        val admissionMongo = admissionRepository.findByIdOrNull(id)
        return admissionMongo?.let {converter.convertToModel(it)}
    }

    override fun findByDivisionId(divisionId: String): List<Admission> {
        val admissionMongoEntities: List<AdmissionMongoEntity> = admissionRepository.findByDivisionId(divisionId)
        return converter.convertListToModels(admissionMongoEntities)
    }

    override fun findByPatientId(patientId: UUID): Admission? {
        val admissionMongo = admissionRepository.findByPatientId(patientId)
        return admissionMongo?.let {converter.convertToModel(it)}
    }

    override fun deleteByPatientId(patientId: UUID) {
        admissionRepository.deleteByPatientId(patientId)
    }
}