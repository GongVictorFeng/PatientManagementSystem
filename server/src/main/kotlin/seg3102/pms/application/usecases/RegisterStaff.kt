package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount
import java.util.*

interface RegisterStaff {
    fun registerStaff(staffInfo: StaffRegisterDto): StaffAccount?
}