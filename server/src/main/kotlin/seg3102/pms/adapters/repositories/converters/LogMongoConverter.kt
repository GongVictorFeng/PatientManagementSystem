package seg3102.pms.adapters.repositories.converters


import org.mapstruct.Mapper
import seg3102.pms.domain.log.entities.Log
import seg3102.pms.infrastructure.mongodb.entities.LogMongoEntity

@Mapper
interface LogMongoConverter {
    fun convertToMongo(log: Log): LogMongoEntity

    fun convertToModel(logMongoEntity: LogMongoEntity): Log
}