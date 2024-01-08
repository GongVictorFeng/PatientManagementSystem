package seg3102.pms.adapters.factories

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3102.pms.application.dtos.converters.StaffAccountDtoConverter
import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.factories.StaffFactory

@Primary
@Component
class StaffAccountDtoFactory: StaffFactory {
    private val dtoConverter = Mappers.getMapper(StaffAccountDtoConverter::class.java)
    override fun createAccount(staffInfo: StaffRegisterDto): StaffAccount {
        return dtoConverter.convertDto(staffInfo)
    }
}