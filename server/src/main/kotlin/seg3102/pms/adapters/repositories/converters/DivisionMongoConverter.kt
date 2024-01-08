package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.infrastructure.mongodb.entities.division.DivisionMongoEntity

@Mapper
interface DivisionMongoConverter {
    fun convertToMongo(division: Division): DivisionMongoEntity
    fun convertToModel(divisionMongoEntity: DivisionMongoEntity): Division
}