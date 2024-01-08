package seg3102.pms.domain.division.entities

import java.util.UUID

enum class RequestState {
    UNMARKED, ACCEPTED, DENIED
}

class Request(
    val requestId: UUID,
    val patientId: UUID,
    val divisionId: String,
    // val staffId: String,
    val rationale: String,
    val priority: Int,
    val localDoctor: String
) {
    var state: RequestState = RequestState.UNMARKED

    fun isUnmarked(): Boolean {
        return state == RequestState.UNMARKED
    }

    fun markAsAccepted() {
        state = RequestState.ACCEPTED
    }

    fun markAsDenied() {
        state = RequestState.DENIED
    }
}