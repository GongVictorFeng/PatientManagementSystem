package seg3102.pms.domain.division.factories

import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.domain.division.entities.Division

interface DivisionFactory {
    fun createDivision(divisionInfo: DivisionCreationDto): Division
}