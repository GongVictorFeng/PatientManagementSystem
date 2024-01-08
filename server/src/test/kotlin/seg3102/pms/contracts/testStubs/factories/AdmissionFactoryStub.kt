package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.factories.AdmissionFactory
import java.util.*

class AdmissionFactoryStub: AdmissionFactory {
    override fun createAdmission(divisionId: String, admissionInfo: PatientAdmissionDto): Admission {
        val admission = Admission(
            UUID.randomUUID(),
            admissionInfo.localDoctor,
            admissionInfo.roomNum,
            admissionInfo.bedNumber,
            divisionId,
            admissionInfo.privateInsuranceNum,
            admissionInfo.patientId)
        return admission
    }
}