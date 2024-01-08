package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import seg3102.pms.infrastructure.mongodb.entities.PrescriptionMongoEntity
import java.util.UUID

@Repository
interface PrescriptionMongoRepository: MongoRepository<PrescriptionMongoEntity, UUID> {
    fun findAllByPatientId(patientId: UUID): List<PrescriptionMongoEntity>
}