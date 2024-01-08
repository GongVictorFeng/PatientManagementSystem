package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.LoginRequest
import seg3102.pms.application.usecases.StaffLogin
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.facade.StaffFacade

class StaffLoginImpl(private var staffFacade: StaffFacade): StaffLogin {
    override fun login(loginRequest: LoginRequest): StaffAccount? {
        val staff = staffFacade.getStaffByName(loginRequest.username)
        if(staff?.password != loginRequest.password) return null
        return staff
    }
}