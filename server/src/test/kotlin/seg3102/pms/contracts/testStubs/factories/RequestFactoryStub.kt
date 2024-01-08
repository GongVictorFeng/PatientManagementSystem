package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.factories.RequestFactory
import java.util.*

class RequestFactoryStub: RequestFactory {
    override fun createRequest(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto): Request {
        return Request(
            UUID.randomUUID(),
            patientId,
            divisionId,
            requestInfo.rationale,
            requestInfo.priority,
            requestInfo.localDoctor
            )
    }
}