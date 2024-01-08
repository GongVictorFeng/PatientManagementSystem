package seg3102.pms.infrastructure.mongodb.entities.division

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import java.util.UUID

enum class RequestState {
    UNMARKED, ACCEPTED, DENIED
}

@Document(collection = "requests")
data class RequestMongoEntity(
    @Id val requestId: UUID,
    val patientId: UUID,
    val divisionId: String,
    // val staffId: String,
    val rationale: String,
    val priority: Int,
    val localDoctor: String,
    var state: RequestState = RequestState.UNMARKED
)