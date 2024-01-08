package seg3102.pms.domain.staff.factories

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount

interface StaffFactory {
    fun createAccount(staffInfo: StaffRegisterDto): StaffAccount
}