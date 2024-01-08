package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.application.usecases.UpdatePatient
import seg3102.pms.domain.log.facade.LogFacade
import seg3102.pms.domain.patient.facade.PatientFacade
import java.util.*

class UpdatePatientImpl(
    private var patientFacade: PatientFacade,
    private var logFacade: LogFacade
): UpdatePatient
{

    override fun updatePatient(patientInfo: PatientRegisterDto, patientId: UUID, staffId: String): Boolean
    { 
        var u = patientFacade.updatePatient(patientId, patientInfo) 
        if( u == true){
            val logId = logFacade.createLog("Patient updated")
            logFacade.addPatientToLog(patientId, logId)
            logFacade.addStaffToLog(staffId, logId)
            return true
        }
        return false
    }
}
 