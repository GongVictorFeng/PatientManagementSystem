package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.application.usecases.AdmitPatient
import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.log.facade.LogFacade

class AdmitPatientImpl(private var divisionFacade: DivisionFacade,
                       private var logFacade: LogFacade): AdmitPatient {
    override fun addPatient(divisionId: String, admissionInfo: PatientAdmissionDto): Boolean {
        val c = divisionFacade.isComplete(divisionId)
        val occupy = divisionFacade.getBedStatus(admissionInfo.room, admissionInfo.bed)
        if(!c && !occupy){
            divisionFacade.occupyBed(admissionInfo.patientId,admissionInfo.room, admissionInfo.bed)
            divisionFacade.createAdmission(divisionId,admissionInfo)
            divisionFacade.updateDivision(divisionId)
            val cnId = divisionFacade.getChargeNurse(divisionId) ?: return false
            val logId = logFacade.createLog("admit patient")
            logFacade.addStaffToLog(cnId, logId)
            logFacade.addPatientToLog(admissionInfo.patientId, logId)
            return true
        }
        return false
    }
}