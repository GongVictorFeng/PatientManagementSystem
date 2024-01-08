package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.repositories.AdmissionRepository
import java.util.*
import kotlin.collections.HashMap

class AdmissionRepositoryStub: AdmissionRepository {
    private val admissions: MutableMap<UUID, Admission> = HashMap()

    override fun save(admission: Admission): Admission {
        admissions[admission.id] = admission
        return admission
    }

    override fun find(id: UUID): Admission? = admissions[id]
}