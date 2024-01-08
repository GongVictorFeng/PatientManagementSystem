package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.factories.PatientFactory

import java.util.*

class PatientFactoryStub: PatientFactory {
    override fun createPatient(patientInfo: PatientRegisterDto): Patient {
        return Patient(UUID.randomUUID(),
                        patientInfo.insuranceNum,
                        patientInfo.firstName,
                        patientInfo.lastName,
                        patientInfo.address,
                        patientInfo.phoneNum,
                        patientInfo.dOB,
                        patientInfo.gender,
                        patientInfo.martialStatus,
                        patientInfo.famDoctor)
    }
}