package seg3102.pms.domain.prescription.facade.implementation

import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.application.usecases.PrescribePrescription
import seg3102.pms.domain.prescription.facade.PrescriptionFacade
import seg3102.pms.domain.prescription.factories.PrescriptionFactory
import seg3102.pms.domain.prescription.repositories.PrescriptionRepository
import seg3102.pms.domain.prescription.events.NewPrescriptionAdded
import seg3102.pms.application.services.DomainEventEmitter
import java.time.LocalDate
import java.util.*
import java.time.LocalDateTime

class PrescriptionFacadeImpl(
    private var prescriptionFactory: PrescriptionFactory,
    private var prescriptionRepository: PrescriptionRepository,
    private var eventEmitter: DomainEventEmitter): PrescriptionFacade{

    override fun addPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID): UUID
    {
        val p = prescriptionFactory.createPrescription(prescriptionInfo, patientId)
        prescriptionRepository.save(p)
        eventEmitter.emit(NewPrescriptionAdded(UUID.randomUUID(), Date(), p.id))
        return p.id
    }

    override fun getPrescriptionName(prescriptionId: UUID): String?
    { return prescriptionRepository.find(prescriptionId)?.drugName }

    override fun getPrescriptionDosage(prescriptionId: UUID): String?
    { 
        val p = prescriptionRepository.find(prescriptionId)
        val dosage = p?.unitsByDay
        val adminPerDay = p?.numAdminPerDay

        return "$dosage units, $adminPerDay times per day"
    }

    override fun getPrescriptionNum(prescriptionId: UUID): String?
    { return prescriptionRepository.find(prescriptionId)?.drugNum }
    
    override fun getPrescriptionMethod(prescriptionId: UUID): String?
    { return prescriptionRepository.find(prescriptionId)?.methodOfAdministration }
    
    override fun getPrescriptionStart(prescriptionId: UUID): LocalDate?
    { return prescriptionRepository.find(prescriptionId)?.startDate }
    
    override fun getPrescriptionFinish(prescriptionId: UUID): LocalDate?
    { return prescriptionRepository.find(prescriptionId)?.finishDate }
    
    override fun getPrescriptionAdmin(prescriptionId: UUID): List<String>?
    { return prescriptionRepository.find(prescriptionId)?.administrationTimes }
    
}
 
