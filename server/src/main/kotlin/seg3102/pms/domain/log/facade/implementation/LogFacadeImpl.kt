package seg3102.pms.domain.log.facade.implementation

import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.log.events.NewLogAdded
import seg3102.pms.domain.log.facade.LogFacade
import seg3102.pms.domain.log.factories.LogFactory
import seg3102.pms.domain.log.repositories.LogRepository
import java.util.*

class LogFacadeImpl(
    private var logRepository: LogRepository,
    private var logFactory: LogFactory,
    private var eventEmitter: DomainEventEmitter):LogFacade {
    override fun createLog(s: String): UUID {
        val log = logFactory.createLog(s)
        logRepository.save(log)
        eventEmitter.emit(NewLogAdded(UUID.randomUUID(),Date(),log.id))
        return log.id
    }

    override fun addStaffToLog(cnId: String, logId: UUID) {
        val log = logRepository.find(logId)
        if(log != null){
            log.staff = cnId
            logRepository.save(log)
        }
    }

    override fun addPatientToLog(patientId: UUID, logId: UUID) {
        val log = logRepository.find(logId)
        if(log != null){
            log.patient = patientId
            logRepository.save(log)
        }
    }

    override fun addPrescriptionToLog(prescriptionId: UUID, logId: UUID){
        val log = logRepository.find(logId)
        if(log != null){
            log.prescription = prescriptionId
            logRepository.save(log)
        }
    }
}