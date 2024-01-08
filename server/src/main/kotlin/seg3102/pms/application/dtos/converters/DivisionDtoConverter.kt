package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.domain.division.entities.Division

@Mapper
interface DivisionDtoConverter {
    @Mappings(
        Mapping(target = "complete", ignore = true)
    )
    fun convertDto(divisionCreationDto: DivisionCreationDto): Division
}