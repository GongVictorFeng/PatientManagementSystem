package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.responses.VisualizeDivisionDto
import seg3102.pms.domain.division.entities.*
import seg3102.pms.domain.division.entities.ward.Bed

@Mapper
interface VisualizeDivisionDtoConverter {
    @Mappings(
        Mapping(target = "divisionId", source = "division.divisionId"),
        Mapping(target = "divisionName", source = "division.divisionName"),
        Mapping(target = "chargeNurseId", source = "division.chargeNurseId"),
        Mapping(target = "location", source = "division.location"),
        Mapping(target = "bedNum", source = "division.bedNum"),
        Mapping(target = "occupiedBedNum", source = "division.occupiedBedNum"),
        Mapping(target = "extensionNum", source = "division.extensionNum")
    )
    fun convertToDto(
        division: Division,
        beds: List<Bed>,
        admissions: List<Admission>,
        requests: List<Request>
    ): VisualizeDivisionDto
}