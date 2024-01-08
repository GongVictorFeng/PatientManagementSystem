package seg3102.pms.domain.prescription.facade

import seg3102.pms.application.dtos.queries.PrescriptionDto
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

interface PrescriptionFacade {
    fun addPrescription(prescriptionInfo: PrescriptionDto, patientId: UUID): UUID
    fun getPrescriptionName(prescriptionId: UUID): String?
    fun getPrescriptionDosage(prescriptionId: UUID): String?
    fun getPrescriptionNum(prescriptionId: UUID): String?
    fun getPrescriptionMethod(prescriptionId: UUID): String?
    fun getPrescriptionStart(prescriptionId: UUID): LocalDate?
    fun getPrescriptionFinish(prescriptionId: UUID): LocalDate?
    fun getPrescriptionAdmin(prescriptionId: UUID): List<String>?
}