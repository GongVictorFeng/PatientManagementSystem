package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.domain.division.entities.ward.Bed

interface CreateBed {
    fun addBed(bedCreationDto: BedCreationDto,divisionId: String): Bed?
}