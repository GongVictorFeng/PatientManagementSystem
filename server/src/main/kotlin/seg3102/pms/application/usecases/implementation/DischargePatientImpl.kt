package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.usecases.DischargePatient
import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.log.facade.LogFacade
import java.util.*

class DischargePatientImpl(
    private var divisionFacade: DivisionFacade,
    private var logFacade: LogFacade
) : DischargePatient {
    override fun dischargePatient(divisionId: String, patientId: UUID): Boolean {
        val bed = divisionFacade.getBed(patientId) ?: return false
        divisionFacade.unoccupyBed(bed)
        divisionFacade.updateDivisionForDischarge(divisionId)
        divisionFacade.updateAdmissionForDischarge(patientId)
        val cnId = divisionFacade.getChargeNurse(divisionId) ?: return false
        val logId = logFacade.createLog("discharge patient")
        logFacade.addStaffToLog(cnId, logId)
        logFacade.addPatientToLog(patientId, logId)
        return true
    }
}