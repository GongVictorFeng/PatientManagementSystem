package seg3102.pms.domain.division.factories

import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.domain.division.entities.Request
import java.util.UUID

interface RequestFactory {
    fun createRequest(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto): Request
}