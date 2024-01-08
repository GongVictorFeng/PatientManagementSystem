package seg3102.pms.domain.staff.facade.implementation

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.staff.facade.StaffFacade
import seg3102.pms.domain.staff.repositories.StaffAccountRepository
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.events.NewStaffRegistered
import seg3102.pms.domain.staff.factories.StaffFactory
import java.util.*

class StaffFacadeImpl (
    private val staffRepository: StaffAccountRepository,
    private val staffFactory: StaffFactory,
    private var eventEmitter: DomainEventEmitter
): StaffFacade {

    override fun registerStaff(staffInfo: StaffRegisterDto):StaffAccount {

        val staff = staffFactory.createAccount(staffInfo)
        if(staffInfo.role != null){
            staff.assignRoleToAccount(staffInfo.role)
        }
        staffRepository.save(staff)
        eventEmitter.emit(
            NewStaffRegistered(UUID.randomUUID(),
                Date(),
                staff.employeeNumber)
        )
        return staff
    }


    override fun checkExistingStaff(employeeNumber: String): Boolean {
        val staff = staffRepository.find(employeeNumber)
        return (staff != null)
    }

    fun isLogged(staffId: String): Boolean {

        return (true)
    }

    override fun findAllStaff(): List<StaffAccount> {
        return staffRepository.findAll()
    }

    override fun getStaffAccount(employeeNumber: String): StaffAccount? {
        return staffRepository.find(employeeNumber)
    }

    override fun getStaffByName(name: String): StaffAccount? {
        return staffRepository.findByName(name)
    }

    override fun deleteAccount(employeeNumber: String): Boolean {
        staffRepository.delete(employeeNumber)
        return true
    }

    override fun saveChange(staff: StaffAccount): StaffAccount {
        staffRepository.save(staff)
        return staff
    }
}