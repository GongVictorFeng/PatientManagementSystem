package seg3102.pms.infrastructure.services

import org.springframework.stereotype.Service
import seg3102.pms.application.dtos.queries.*
import seg3102.pms.application.dtos.responses.PatientFileDto
import seg3102.pms.application.dtos.responses.VisualizeDivisionDto
import seg3102.pms.application.usecases.*
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.infrastructure.mongodb.dao.StaffAccountMongoRepository
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.repositories.AdmissionRepository
import seg3102.pms.domain.division.repositories.RequestRepository
import seg3102.pms.infrastructure.mongodb.dao.BedMongoRepository
import seg3102.pms.infrastructure.mongodb.entities.BedMongoEntity

import java.util.*

@Service
class PmsService(
    private val consultPatientFile: ConsultPatientFile,
    private val registerPatient: RegisterPatient,
    private val registerStaff: RegisterStaff,
    private val staffLogin: StaffLogin,
    private val visualizeDivision: VisualizeDivision,
    private val prescribePrescription: PrescribePrescription,
    private val createDivision: CreateDivision,
    private val admitPatient: AdmitPatient,
    private val admitPatientFromRequest: AdmitPatientFromRequest,
    private val dischargePatient: DischargePatient,
    private val updatePatient: UpdatePatient,
    private val requestPatientAdmission: RequestPatientAdmission,
    private val staffAccountMongoRepository: StaffAccountMongoRepository,
    private val createBed: CreateBed,
    private val bedMongoRepository: BedMongoRepository,
    private val admissionRepository: AdmissionRepository,
    private val requestRepository: RequestRepository,
) {
    fun findPatient(patientId: UUID, staffId: String): PatientFileDto {
        val patientFile = consultPatientFile.findPatient(patientId, staffId)
        if (patientFile == null) {
            throw NoSuchElementException("No patient with received id " + patientId.toString())
        } else {
            return patientFile
        }
    }

    fun registerPatient(patientInfo: PatientRegisterDto): UUID? {
        return registerPatient.registerPatient(patientInfo)
    }

    fun registerStaff(staffInfo: StaffRegisterDto): StaffAccount? {
        if(staffAccountMongoRepository.existsByName(staffInfo.name)  || staffAccountMongoRepository.existsById(staffInfo.employeeNumber)){
            return null
        }
        return registerStaff.registerStaff(staffInfo)
    }

    fun login(loginRequest: LoginRequest): StaffAccount? {
        if(!staffAccountMongoRepository.existsByName(loginRequest.username)) {
            return null
        }
       return staffLogin.login(loginRequest)
    }

    fun addPrescription(prescriptionDto: PrescriptionDto, patientId: String, employeeNumber: String): UUID? {
        val patientUuid = UUID.fromString(patientId)
        return prescribePrescription.addPrescription(prescriptionDto, patientUuid, employeeNumber)
    }

    fun addBed(bedInfo: BedCreationDto, divisionId: String): Bed? {
        return createBed.addBed(bedInfo, divisionId)
    }

    fun getAllBedsByDivision(divisionId: String): List<BedMongoEntity> {
        return bedMongoRepository.findAllByDivisionId(divisionId)
    }

    fun admitPatient(divisionId: String, admissionInfo: PatientAdmissionDto): Boolean {
        return admitPatient.addPatient(divisionId, admissionInfo)
    }

    fun admitPatientFromRequest(requestId: UUID, staffId: String, admissionInfo: PatientAdmissionDto?): Boolean {
        return admitPatientFromRequest.admitPatientFromRequest(requestId, staffId, admissionInfo)
    }

    fun dischargePatient(divisionId: String, patientId: UUID): Boolean {
        return dischargePatient.dischargePatient(divisionId, patientId)
    }

    fun updatePatient(patientInfo: PatientRegisterDto, patientId: UUID, staffId: String): Boolean {
        return updatePatient.updatePatient(patientInfo, patientId, staffId)
    }

    fun getAdmissionsByDivision(divisionId: String): List<Admission> {
        return admissionRepository.findByDivisionId(divisionId)
    }

    fun getRequestsByDivision(divisionId: String): List<Request> {
        return requestRepository.findByDivisionId(divisionId)
    }

    fun requestPatientAdmission(patientId: UUID, divisionId: String, staffId: String, requestInfo: RequestCreateDto): UUID? {
        return requestPatientAdmission.requestPatientAdmission(patientId, divisionId, staffId, requestInfo)
    }

    fun addDivision(divisionInfo: DivisionCreationDto): Division? {
        return createDivision.addDivision(divisionInfo)
    }

    fun visualizeDivision(divisionId: String): VisualizeDivisionDto {
        val divisionDto = visualizeDivision.visualizeDivision(divisionId)
        if (divisionDto == null) {
            throw NoSuchElementException("No division with received id " + divisionId)
        } else {
            return divisionDto
        }
    }
}