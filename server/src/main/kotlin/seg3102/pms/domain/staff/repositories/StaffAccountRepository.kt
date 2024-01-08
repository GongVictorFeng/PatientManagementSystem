package seg3102.pms.domain.staff.repositories

import seg3102.pms.domain.staff.entities.StaffAccount

interface StaffAccountRepository {
    fun find(employeeNumber: String): StaffAccount?
    fun save(staffAccount: StaffAccount): StaffAccount
    fun findByName(name: String): StaffAccount?

    fun delete(employeeNumber: String): Boolean

    fun findAll(): List<StaffAccount>
}
