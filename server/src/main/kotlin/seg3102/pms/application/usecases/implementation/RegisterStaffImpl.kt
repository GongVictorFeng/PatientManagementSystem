package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.application.usecases.RegisterStaff
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.facade.StaffFacade

class RegisterStaffImpl(private val staffFacade: StaffFacade): RegisterStaff {
    override fun registerStaff(staffInfo: StaffRegisterDto): StaffAccount? {
        return staffFacade.registerStaff(staffInfo)
    }
}