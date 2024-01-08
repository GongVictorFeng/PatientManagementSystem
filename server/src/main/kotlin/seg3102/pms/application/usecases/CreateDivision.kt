package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.domain.division.entities.Division

interface CreateDivision {
    fun addDivision(divisionCreationDto: DivisionCreationDto): Division?
}