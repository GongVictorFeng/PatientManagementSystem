package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

import seg3102.pms.infrastructure.mongodb.entities.division.RequestMongoEntity

import java.util.UUID

@Repository
interface RequestMongoRepository: MongoRepository<RequestMongoEntity, UUID> {
    @Query("{'divisionId': ?0}")
    fun findByDivisionId(divisionId: String): List<RequestMongoEntity>

    @Query("{'patientId': ?0}")
    fun findByPatientId(patientId: UUID): RequestMongoEntity?
}