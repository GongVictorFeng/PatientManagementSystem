package seg3102.pms.domain.division.factories

import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.domain.division.entities.ward.Bed

interface BedFactory {
    fun createBed(bedInfo: BedCreationDto, divisionId: String): Bed
}