package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.infrastructure.mongodb.entities.division.RequestMongoEntity

@Mapper
interface RequestMongoConverter {
    fun convertToMongo(request: Request): RequestMongoEntity
    fun convertToModel(requestMongoEntity: RequestMongoEntity): Request
    fun convertListToModels(requestMongoEntities: List<RequestMongoEntity>): List<Request>
}
