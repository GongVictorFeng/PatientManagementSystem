package seg3102.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.infrastructure.mongodb.entities.BedMongoEntity

@Mapper
interface BedMongoConverter {
    fun convertToMongo(bed: Bed): BedMongoEntity

    fun convertToModel(bedMongo: BedMongoEntity): Bed
}