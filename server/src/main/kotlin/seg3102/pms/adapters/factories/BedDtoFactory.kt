package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3102.pms.application.dtos.converters.BedDtoConverter
import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.factories.BedFactory

@Primary
@Component
class BedDtoFactory: BedFactory {
    private val dtoConverter = Mappers.getMapper(BedDtoConverter::class.java)
    override fun createBed(bedInfo: BedCreationDto, divisionId:String): Bed {
        return dtoConverter.convertDto(bedInfo, divisionId)
    }
}