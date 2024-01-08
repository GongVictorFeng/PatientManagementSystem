package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.repositories.StaffAccountRepository
import kotlin.collections.HashMap

class StaffAccountRepositoryStub: StaffAccountRepository {
    private  val staffs: MutableMap<String, StaffAccount> = HashMap()
    override fun findByName(name: String): StaffAccount? {
        TODO("Not yet implemented")
    }

    override fun delete(employeeNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<StaffAccount> {
        TODO("Not yet implemented")
    }

    override fun save(staffAccount: StaffAccount): StaffAccount {
        staffs[staffAccount.employeeNumber] = staffAccount
        return staffAccount
    }

    override fun find(employeeNumber: String): StaffAccount? = staffs[employeeNumber]
}