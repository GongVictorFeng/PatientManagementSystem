package seg3102.pms.domain.patient.facade.implementation

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.patient.facade.PatientFacade
import seg3102.pms.domain.patient.factories.PatientFactory
import seg3102.pms.domain.patient.repositories.PatientRepository
import seg3102.pms.domain.patient.events.NewPatientRegistered
import seg3102.pms.domain.patient.events.PatientUpdated
import seg3102.pms.domain.patient.entities.Patient
import java.math.BigDecimal
import java.util.*

class PatientFacadeImpl(
    private val patientRepository: PatientRepository,
    private val patientFactory: PatientFactory,
    private var eventEmitter: DomainEventEmitter): PatientFacade {

    override fun findPatient(patientId: UUID): Patient? {
        val patient = patientRepository.find(patientId)
        return patient
    }

    override fun registerPatient(patientInfo: PatientRegisterDto):UUID {
        
        // val patient = createPatient(patientInfo)

        val patient = patientFactory.createPatient(patientInfo)
        patientRepository.save(patient)

        eventEmitter.emit(
            NewPatientRegistered(UUID.randomUUID(),
                Date(),
                patient.id)
        )
        return patient.id
    }

    override fun checkExistingPatient(patientInfo: PatientRegisterDto): Boolean {
        val patient = patientRepository.find(patientInfo)
        return (patient == null) 
    }


    override fun updatePatient(patientId: UUID, patientInfo: PatientRegisterDto): Boolean {
        val patient = patientRepository.find(patientId)
        if (patient != null) {
            val updated = patientFactory.createPatient(patientInfo)
            patient.update(updated)
            patientRepository.save(patient)
            eventEmitter.emit(
                PatientUpdated(UUID.randomUUID(),
                    Date(),
                    patient.id)
            )
            return true
        }
        return false
    }
}