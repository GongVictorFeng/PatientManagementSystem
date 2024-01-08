package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.StaffRegisterDto
import seg3102.pms.domain.staff.entities.StaffAccount

@Mapper
interface StaffAccountDtoConverter {
    @Mappings(
        Mapping(target = "role", ignore = true)
    )
    fun convertDto(staffRegisterDto: StaffRegisterDto): StaffAccount
}