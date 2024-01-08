package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import seg3102.pms.infrastructure.mongodb.entities.BedMongoEntity
import java.util.*

interface BedMongoRepository: MongoRepository<BedMongoEntity, String> {
    fun findByRoomIdAndBedId(roomId: String, bedId: String): BedMongoEntity?

    fun findByPatientId(patientId: UUID): BedMongoEntity?

    fun findAllByDivisionId(divisionID: String): List<BedMongoEntity>

    fun deleteByRoomIdAndBedId(roomId: String, bedId: String)

}