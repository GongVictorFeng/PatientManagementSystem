package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.repositories.PatientRepository
import java.util.*
import kotlin.collections.HashMap

class PatientRepositoryStub : PatientRepository {
    private val patients: MutableMap<UUID, Patient> = HashMap()

    override fun save(patient: Patient): Patient {
        patients[patient.id] = patient
        return patient
    }


    override fun find(id: UUID): Patient? = patients[id]

    override fun find(patient: PatientRegisterDto): Patient? {
        return patients.values.find { (it.insuranceNum == patient.insuranceNum) && (it.firstName == patient.firstName)}
    }
}
