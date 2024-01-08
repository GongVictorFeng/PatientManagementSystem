package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.domain.prescription.repositories.PrescriptionRepository
import java.util.*
import kotlin.collections.HashMap

class PrescriptionRepositoryStub : PrescriptionRepository {
    private val prescriptions: MutableMap<UUID, Prescription> = HashMap()

    override fun save(prescription: Prescription): Prescription {
        prescriptions[prescription.id] = prescription
        return prescription
    }

    override fun find(id: UUID): Prescription? = prescriptions[id]
}
