package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.application.dtos.converters.PatientDtoConverter
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.factories.PatientFactory

import java.util.UUID

@Primary
@Component
class PatientDtoFactory: PatientFactory {
    private val dtoConverter = Mappers.getMapper(PatientDtoConverter::class.java)

    override fun createPatient(patientInfo: PatientRegisterDto): Patient {
        val patient = dtoConverter.convertDto(patientInfo, UUID.randomUUID())
        return patient
    }
}
