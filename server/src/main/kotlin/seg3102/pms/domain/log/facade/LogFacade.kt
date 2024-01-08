package seg3102.pms.domain.log.facade

import java.util.*

interface LogFacade {
    fun createLog(s: String): UUID
    fun addStaffToLog(cnId: String, logId: UUID)
    fun addPatientToLog(patientId: UUID, logId: UUID)
    fun addPrescriptionToLog(prescriptionId: UUID, logId: UUID)
}