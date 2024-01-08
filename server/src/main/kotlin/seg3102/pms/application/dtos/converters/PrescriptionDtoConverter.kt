package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.domain.prescription.entities.Prescription
import java.util.UUID

@Mapper
interface PrescriptionDtoConverter {
    @Mappings(
        Mapping(target = "startDate", source = "prescriptionDto.startDate", dateFormat = "MM/dd/yyyy"),
        Mapping(target = "finishDate", source = "prescriptionDto.finishDate", dateFormat = "MM/dd/yyyy"),
    )
    fun convertDto(prescriptionDto: PrescriptionDto, id: UUID, patientId: UUID): Prescription
}