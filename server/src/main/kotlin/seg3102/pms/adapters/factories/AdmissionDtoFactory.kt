package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.application.dtos.converters.AdmissionDtoConverter
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.factories.AdmissionFactory

import java.util.UUID

@Primary
@Component
class AdmissionDtoFactory: AdmissionFactory {
    private val dtoConverter = Mappers.getMapper(AdmissionDtoConverter::class.java)

    override fun createAdmission(divisionId: String, admissionInfo: PatientAdmissionDto): Admission {
        val admission = dtoConverter.convertDto(divisionId, admissionInfo, UUID.randomUUID())
        return admission
    }
}
