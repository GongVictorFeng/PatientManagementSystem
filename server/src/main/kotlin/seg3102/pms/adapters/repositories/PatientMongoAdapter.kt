package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import seg3102.pms.adapters.repositories.converters.PatientMongoConverter
import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.repositories.PatientRepository
import seg3102.pms.infrastructure.mongodb.dao.PatientMongoRepository
import seg3102.pms.infrastructure.mongodb.entities.patient.PatientMongoEntity
import seg3102.pms.infrastructure.mongodb.entities.patient.AddressMongoEntity
import seg3102.pms.infrastructure.mongodb.entities.patient.NextOfKinMongoEntity

import java.util.UUID

@Component
class PatientMongoAdapter(private val patientRepository: PatientMongoRepository): PatientRepository {
    private val converter = Mappers.getMapper(PatientMongoConverter::class.java)

    override fun save(patient: Patient): Patient {
        val patientMongo = converter.convertToMongo(patient)
        patientRepository.save(patientMongo)
        return patient
    }

    // TODO...
    override fun find(patient: PatientRegisterDto): Patient? {
        return null
    }

    override fun find(id: UUID): Patient? {
        val patientMongo = patientRepository.findById(id)
        val patient = converter.convertToModel(patientMongo.orElse(null))
        return patient
    }
}