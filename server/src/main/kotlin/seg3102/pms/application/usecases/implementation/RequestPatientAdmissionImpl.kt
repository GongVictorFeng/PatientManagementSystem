package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.usecases.RequestPatientAdmission
import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.domain.staff.facade.StaffFacade
import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.log.facade.LogFacade

import java.util.UUID

class RequestPatientAdmissionImpl(
    private val staffFacade: StaffFacade,
    private val divisionFacade: DivisionFacade,
    private val logFacade: LogFacade
): RequestPatientAdmission{
    override fun requestPatientAdmission(patientId: UUID, divisionId: String, staffId: String, requestInfo: RequestCreateDto): UUID? {
        var requestId: UUID? = null
        val inCharge = divisionFacade.isInChargeOfDiv(staffId, divisionId)
        val admission = divisionFacade.getAdmissionByPatientId(patientId)
        if (inCharge && admission == null && requestInfo != null) {
            requestId = divisionFacade.addRequest(patientId, divisionId, requestInfo)
            val logId = logFacade.createLog("Requested admission")
            logFacade.addStaffToLog(staffId, logId)
            logFacade.addPatientToLog(patientId, logId)
        }
        return requestId
    }
}