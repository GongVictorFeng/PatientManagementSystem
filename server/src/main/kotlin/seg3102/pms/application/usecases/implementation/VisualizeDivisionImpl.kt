package seg3102.pms.application.usecases.implementation

import org.mapstruct.factory.Mappers
import seg3102.pms.application.dtos.converters.VisualizeDivisionDtoConverter
import seg3102.pms.application.dtos.responses.VisualizeDivisionDto
import seg3102.pms.application.usecases.VisualizeDivision
import seg3102.pms.domain.division.facade.DivisionFacade

class VisualizeDivisionImpl(
    private val divisionFacade: DivisionFacade
): VisualizeDivision {
    private val converter = Mappers.getMapper(VisualizeDivisionDtoConverter::class.java)

    override fun visualizeDivision(divisionId: String): VisualizeDivisionDto? {
        val division = divisionFacade.getDivision(divisionId)
        val beds = divisionFacade.getAllBeds(divisionId)
        val admissions = divisionFacade.getAdmissionsOfDivision(divisionId)
        val requests = divisionFacade.getRequestsOfDivision(divisionId)
        return division?.let {converter.convertToDto(it, beds, admissions, requests)}
    }
}