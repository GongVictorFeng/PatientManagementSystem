package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.repositories.RequestRepository
import java.util.HashMap
import java.util.UUID

class RequestRepositoryStub: RequestRepository {
    private val requests: MutableMap<UUID, Request> = HashMap()

    override fun save(request: Request): Request {
        requests[request.requestId] = request
        return request
    }

    override fun find(requestId: UUID): Request? = requests[requestId]
}