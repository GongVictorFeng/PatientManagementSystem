package seg3102.pms.domain.division.facade

import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.entities.ward.Bed
import java.util.UUID

interface DivisionFacade {
    fun isComplete(divisionId: String): Boolean
    // fun updateDivision(divisionId: String, admissionId: UUID)
    fun getChargeNurse(divisionId: String): String?
    fun getBedStatus(roomId: String, bedId: String): Boolean
    fun occupyBed(patientId: UUID, roomId: String, bedId: String)
    fun createAdmission(divisionId: String, admissionInfo: PatientAdmissionDto): UUID
    fun getBed(patientId: UUID): Bed?
    fun unoccupyBed(bed: Bed)
    fun updateDivision(divisionId: String)
    fun updateDivisionForDischarge(divisionId: String)
    fun isInChargeOfDiv(staffId: String, divisionId: String): Boolean
    fun getAdmissionByPatientId(patientId: UUID): Admission?
    fun addRequest(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto): UUID
    fun requestIsUnmarked(requestId: UUID): Boolean
    fun getRequestedDivision(requestId: UUID): String
    fun getRequestedPatient(requestId: UUID): UUID
    fun acceptRequest(requestId: UUID)
    fun denyRequest(requestId: UUID)
    fun addBed(bedCreationDto: BedCreationDto, divisionId: String): Bed
    fun getAllBeds(divisionId: String): List<Bed>
    fun addDivision(divisionCreationDto: DivisionCreationDto): Division?
    fun updateAdmissionForDischarge(patientId: UUID)
    fun getAdmissionsOfDivision(divisionId: String): List<Admission>
    fun getRequestsOfDivision(divisionId: String): List<Request>
    fun getDivision(divisionId: String): Division?
}