package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.domain.division.entities.ward.Bed

@Mapper
interface BedDtoConverter {
    @Mappings(
        Mapping(target = "patientId", ignore = true),
        Mapping(target = "occupied", ignore = true)
    )
    fun convertDto(bedCreationDto: BedCreationDto, divisionId: String): Bed
}
