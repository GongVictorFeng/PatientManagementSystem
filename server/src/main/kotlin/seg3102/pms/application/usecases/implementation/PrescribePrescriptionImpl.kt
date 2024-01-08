package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.application.usecases.PrescribePrescription
import seg3102.pms.domain.prescription.facade.PrescriptionFacade
import seg3102.pms.domain.log.facade.LogFacade
import java.util.*

class PrescribePrescriptionImpl(
    private var prescriptionFacade: PrescriptionFacade,
    private var logFacade: LogFacade
    ): PrescribePrescription
{
    override fun addPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID, employeeNumber: String): UUID?
    {
        val prId = prescriptionFacade.addPrescription(prescriptionInfo, patientId)
        val logId = logFacade.createLog("prescription for patient")
        logFacade.addPatientToLog(patientId, logId)
        logFacade.addStaffToLog(employeeNumber, logId)
        logFacade.addPrescriptionToLog(prId, logId)
        return prId
    }
}
 
