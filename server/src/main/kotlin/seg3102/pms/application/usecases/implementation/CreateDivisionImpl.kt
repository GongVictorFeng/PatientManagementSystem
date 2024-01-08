package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.application.usecases.CreateDivision
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.facade.DivisionFacade

class CreateDivisionImpl(private val divisionFacade: DivisionFacade): CreateDivision {
    override fun addDivision(divisionCreationDto: DivisionCreationDto): Division? {
        return divisionFacade.addDivision(divisionCreationDto)
    }
}