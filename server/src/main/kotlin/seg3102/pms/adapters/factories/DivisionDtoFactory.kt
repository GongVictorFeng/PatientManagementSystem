package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3102.pms.application.dtos.converters.DivisionDtoConverter
import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.factories.DivisionFactory

@Primary
@Component
class DivisionDtoFactory: DivisionFactory {
    private val dtoConverter = Mappers.getMapper(DivisionDtoConverter::class.java)
    override fun createDivision(divisionInfo: DivisionCreationDto): Division {
        return dtoConverter.convertDto(divisionInfo)
    }
}