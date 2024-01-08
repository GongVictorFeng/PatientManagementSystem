package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.domain.division.entities.Admission

import java.util.UUID

@Mapper
interface AdmissionDtoConverter {
    fun convertDto(divisionId: String, admissionInfo: PatientAdmissionDto, id: UUID): Admission
}