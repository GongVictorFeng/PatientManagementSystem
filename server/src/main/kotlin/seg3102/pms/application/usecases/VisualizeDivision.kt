package seg3102.pms.application.usecases

import seg3102.pms.application.dtos.responses.VisualizeDivisionDto

interface VisualizeDivision {
    fun visualizeDivision(divisionId: String): VisualizeDivisionDto?
}