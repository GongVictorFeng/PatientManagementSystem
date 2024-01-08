package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.LoginRequest
import seg3102.pms.domain.staff.entities.StaffAccount

interface StaffLogin {
    fun login(loginRequest: LoginRequest): StaffAccount?
}