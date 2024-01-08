package seg3102.pms.application.dtos.queries

data class RequestCreateDto (
    val rationale: String,
    val priority: Int,
    val localDoctor: String
)
