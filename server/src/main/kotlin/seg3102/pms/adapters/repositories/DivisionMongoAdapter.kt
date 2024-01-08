package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component

import seg3102.pms.adapters.repositories.converters.DivisionMongoConverter
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.repositories.DivisionRepository
import seg3102.pms.infrastructure.mongodb.dao.DivisionMongoRepository

@Component
class DivisionMongoAdapter(private val divisionRepository: DivisionMongoRepository): DivisionRepository {
    private val converter = Mappers.getMapper(DivisionMongoConverter::class.java)

    override fun save(division: Division): Division {
        val divisionMongo = converter.convertToMongo(division)
        divisionRepository.save(divisionMongo)
        return division
    }

    override fun find(divisionId: String): Division? {
        val divisionMongo = divisionRepository.findById(divisionId)
        val division = converter.convertToModel(divisionMongo.orElse(null))
        return division
    }
}