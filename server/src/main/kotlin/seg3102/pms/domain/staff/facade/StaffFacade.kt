package seg3102.pms.domain.staff.facade

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount

interface StaffFacade {
    fun registerStaff(staffInfo: StaffRegisterDto): StaffAccount?
    fun checkExistingStaff(staffId: String): Boolean
    fun findAllStaff(): List<StaffAccount>
    fun getStaffAccount(employeeNumber: String): StaffAccount?
    fun getStaffByName(name: String): StaffAccount?
    fun deleteAccount(employeeNumber: String): Boolean
    fun saveChange(staff: StaffAccount): StaffAccount
}