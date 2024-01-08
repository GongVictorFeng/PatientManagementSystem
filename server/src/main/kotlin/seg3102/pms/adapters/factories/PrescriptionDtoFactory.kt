package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3102.pms.application.dtos.converters.PrescriptionDtoConverter
import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.domain.prescription.factories.PrescriptionFactory
import java.util.UUID

@Primary
@Component
class PrescriptionDtoFactory: PrescriptionFactory {
    private val dtoConverter = Mappers.getMapper(PrescriptionDtoConverter::class.java)
    override fun createPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID): Prescription {
        return dtoConverter.convertDto(prescriptionInfo, UUID.randomUUID(), patientId)
    }
}