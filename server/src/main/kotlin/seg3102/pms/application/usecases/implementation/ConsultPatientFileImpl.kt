package seg3102.pms.application.usecases.implementation

import org.mapstruct.factory.Mappers
import seg3102.pms.application.dtos.converters.PatientFileDtoConverter
import seg3102.pms.application.dtos.responses.PatientFileDto
import seg3102.pms.application.usecases.ConsultPatientFile
import seg3102.pms.domain.log.facade.LogFacade
import seg3102.pms.domain.patient.facade.PatientFacade

import java.util.UUID

class ConsultPatientFileImpl(
    private val patientFacade: PatientFacade,
    private val logFacade: LogFacade
): ConsultPatientFile {
    private val converter = Mappers.getMapper(PatientFileDtoConverter::class.java)

    override fun findPatient(patientId: UUID, staffId: String): PatientFileDto? {
        val patient = patientFacade.findPatient(patientId)
        if (patient != null) {
            val logId = logFacade.createLog("Consult patient file")
            logFacade.addPatientToLog(patientId, logId)
            logFacade.addStaffToLog(staffId, logId)
            val patientFile = converter.convertToDto(patient)
            return patientFile
        } else {
            return null
        }
    }
}