package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.factories.StaffFactory

class StaffAccountFactoryStub: StaffFactory {
    override fun createAccount(staffInfo: StaffRegisterDto): StaffAccount {
        return StaffAccount(
            staffInfo.employeeNumber,
            staffInfo.name,
            staffInfo.password,
            staffInfo.email)
    }

}