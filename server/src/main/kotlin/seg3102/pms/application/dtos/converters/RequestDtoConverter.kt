package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.domain.division.entities.Request

import java.util.UUID

@Mapper
interface RequestDtoConverter {
    @Mapping(target = "state", ignore = true)
    fun convertDto(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto, requestId: UUID): Request
}