package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.usecases.AdmitPatientFromRequest
import seg3102.pms.application.usecases.AdmitPatient
import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.log.facade.LogFacade

import java.util.UUID

class AdmitPatientFromRequestImpl(
    private val divisionFacade: DivisionFacade,
    private val logFacade: LogFacade,
    private val admitPatient: AdmitPatient
): AdmitPatientFromRequest {
    override fun admitPatientFromRequest(requestId: UUID, staffId: String, admissionInfo: PatientAdmissionDto?): Boolean {
        val divisionId = divisionFacade.getRequestedDivision(requestId)
        val inCharge = divisionFacade.isInChargeOfDiv(staffId, divisionId)
        val isUnmarked = divisionFacade.requestIsUnmarked(requestId)
        if (inCharge && isUnmarked) {
            if (admissionInfo != null) {
                divisionFacade.acceptRequest(requestId)
                admitPatient.addPatient(divisionId, admissionInfo)
            } else if (admissionInfo == null) {
                divisionFacade.denyRequest(requestId)
                val patientId = divisionFacade.getRequestedPatient(requestId)
                val logId = logFacade.createLog("Request denied")
                logFacade.addStaffToLog(staffId, logId)
                logFacade.addPatientToLog(patientId, logId)
            }
            return true
        }
        return false
    }
}
