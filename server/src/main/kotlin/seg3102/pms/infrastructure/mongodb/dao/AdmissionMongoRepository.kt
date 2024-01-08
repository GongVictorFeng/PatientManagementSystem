package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

import seg3102.pms.infrastructure.mongodb.entities.division.AdmissionMongoEntity

import java.util.UUID

@Repository
interface AdmissionMongoRepository: MongoRepository<AdmissionMongoEntity, UUID> {
    @Query("{'divisionId': ?0}")
    fun findByDivisionId(divisionId: String): List<AdmissionMongoEntity>

    @Query("{'patientId': ?0}")
    fun findByPatientId(patientId: UUID): AdmissionMongoEntity?

    fun deleteByPatientId(patientId: UUID)
}