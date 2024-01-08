package seg3102.pms.contracts.testStubs.factories

import seg3102.pms.application.dtos.queries.PrescriptionDto
import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.domain.prescription.factories.PrescriptionFactory
import java.util.*
import java.time.LocalDateTime

class PrescriptionFactoryStub: PrescriptionFactory {
    override fun createPrescription(prescriptionInfo: PrescriptionDto): Prescription {
        var prescription = Prescription(
            UUID.randomUUID(),
            prescriptionInfo.patientId,
            prescriptionInfo.drugNum,
            prescriptionInfo.drugName,
            prescriptionInfo.unitsByDay,
            prescriptionInfo.numAdminPerDay,
            prescriptionInfo.administrationTimes,
            prescriptionInfo.methodOfAdministration,
            // prescriptionInfo.startDate,
            prescriptionInfo.startDate.atStartOfDay(),
            prescriptionInfo.finishDate.atStartOfDay() 
            // prescriptionInfo.finishDate
        )
        return prescription
    }
}
