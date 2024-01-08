package seg3102.pms.domain.division.repositories

import seg3102.pms.domain.division.entities.Request
import java.util.UUID

interface RequestRepository {
    fun save(request: Request): Request
    fun find(requestId: UUID): Request?
    fun findByDivisionId(divisionId: String): List<Request>
    fun findByPatientId(patientId: UUID): Request?
}