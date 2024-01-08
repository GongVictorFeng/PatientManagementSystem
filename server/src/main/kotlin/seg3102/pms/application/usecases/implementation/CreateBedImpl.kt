package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.application.usecases.CreateBed
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.facade.DivisionFacade

class CreateBedImpl(private val divisionFacade: DivisionFacade): CreateBed {
    override fun addBed(bedCreationDto: BedCreationDto, divisionId: String): Bed? {
        return divisionFacade.addBed(bedCreationDto,divisionId)
    }
}