package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3102.pms.adapters.repositories.converters.LogMongoConverter
import seg3102.pms.domain.log.entities.Log
import seg3102.pms.domain.log.repositories.LogRepository
import seg3102.pms.infrastructure.mongodb.dao.LogMongoRepository
import java.util.*

@Component
class LogMongoAdapter(private val logMongoRepository: LogMongoRepository): LogRepository {
    private val converter = Mappers.getMapper(LogMongoConverter::class.java )
    override fun save(log: Log): Log {
        val logMongo = converter.convertToMongo(log)
        logMongoRepository.save(logMongo)
        return log
    }

    override fun find(id: UUID): Log? {
        val logMongo = logMongoRepository.findByIdOrNull(id)
        return logMongo?.let {converter.convertToModel(it)}
    }
}