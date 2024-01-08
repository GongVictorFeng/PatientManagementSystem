package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.application.dtos.converters.RequestDtoConverter
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.factories.RequestFactory

import java.util.UUID

@Primary
@Component
class RequestDtoFactory: RequestFactory {
    private val dtoConverter = Mappers.getMapper(RequestDtoConverter::class.java)

    override fun createRequest(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto): Request {
        val request = dtoConverter.convertDto(patientId, divisionId, requestInfo, UUID.randomUUID())
        return request
    }
}