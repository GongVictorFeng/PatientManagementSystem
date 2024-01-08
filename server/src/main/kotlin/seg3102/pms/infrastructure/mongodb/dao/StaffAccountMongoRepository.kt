package seg3102.pms.infrastructure.mongodb.dao

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import seg3102.pms.infrastructure.mongodb.entities.StaffAccountMongoEntity

@Repository
interface StaffAccountMongoRepository: MongoRepository<StaffAccountMongoEntity, String> {

    fun findByName(name: String): StaffAccountMongoEntity?

    fun existsByName(name: String): Boolean
}