package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import seg3102.pms.infrastructure.mongodb.entities.patient.PatientMongoEntity
import java.util.UUID

@Repository
interface PatientMongoRepository: MongoRepository<PatientMongoEntity, UUID>