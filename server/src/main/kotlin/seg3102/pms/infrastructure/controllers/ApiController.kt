package seg3102.pms.infrastructure.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import seg3102.pms.application.dtos.queries.*
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.infrastructure.mongodb.entities.BedMongoEntity
import seg3102.pms.infrastructure.mongodb.entities.division.DivisionMongoEntity
import seg3102.pms.infrastructure.services.PmsService
import java.util.UUID

@RestController
@CrossOrigin(origins = ["http://localhost:3000"])
class ApiController (
    private val pmsService: PmsService
) {
    @GetMapping("/{staffId}/patient/{id}")
    fun getPatient(@PathVariable("id") id: String, @PathVariable staffId: String): ResponseEntity<Any> {
        try {
            val uuid = UUID.fromString(id)
            val patientFile = pmsService.findPatient(uuid, staffId)
            return ResponseEntity.ok().body(patientFile)
        } catch (e: Exception) {
            println(e)
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping("/patient/register")
    fun addPatient(@RequestBody patientInfo: PatientRegisterDto): ResponseEntity<Any> {
        println(patientInfo)
        try {
            val patientId = pmsService.registerPatient(patientInfo)
            return ResponseEntity.ok().body(patientId)
        } catch (e: IllegalArgumentException) {
            println(e)
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping("/staff/register")
    fun addStaff(@RequestBody staffInfo: StaffRegisterDto): ResponseEntity<Any> {
        val staff: StaffAccount?
        try {
            staff = pmsService.registerStaff(staffInfo)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(staff)
    }

    @PostMapping("/login")
    fun checkLogin(@RequestBody loginRequest: LoginRequest): ResponseEntity<Any> {
        val staff: StaffAccount?
        try {
            staff = pmsService.login(loginRequest)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(staff)
    }

    @PostMapping("/{employeeNumber}/patient/{patientId}/prescription")
    fun addPrescription(@RequestBody prescriptionDto: PrescriptionDto, @PathVariable patientId: String, @PathVariable employeeNumber: String): ResponseEntity<Any> {
        val prescriptionId: UUID?
        println(prescriptionDto)
        try {
            prescriptionId = pmsService.addPrescription(prescriptionDto, patientId,employeeNumber)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(prescriptionId)
    }

    @PostMapping("division/createDivision")
    fun addDivision(@RequestBody divisionInfo: DivisionCreationDto): ResponseEntity<Any>{
        val division: Division?
        try{
            division = pmsService.addDivision(divisionInfo)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(division)
    }

    @PostMapping("/patient/admit/{divisionId}")
    fun admitPatient(
        @RequestBody admissionInfo: PatientAdmissionDto,
        @PathVariable("divisionId") divisionId: String
    ): ResponseEntity<Any> {
        try {
            val result = pmsService.admitPatient(divisionId, admissionInfo)
            if (result) return ResponseEntity.ok().body("Success")
            else return ResponseEntity.badRequest().body("Division full")
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping("/request/admit/{requestId}/{staffId}")
    fun admitFromRequest(
        @RequestBody admissionInfo: PatientAdmissionDto?,
        @PathVariable("requestId") requestId: UUID,
        @PathVariable("staffId") staffId: String
    ): ResponseEntity<Any> {
        try {
            val result = pmsService.admitPatientFromRequest(requestId, staffId, admissionInfo)
            if (result) return ResponseEntity.ok().body("Success")
            else return ResponseEntity.badRequest().body("Request rejected / division full")
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @DeleteMapping("/patient/discharge/{patientId}/{divisionId}")
    fun dischargePatient(
        @PathVariable("patientId") patientId: UUID,
        @PathVariable("divisionId") divisionId: String
    ): ResponseEntity<Any> {
        try {
            val result = pmsService.dischargePatient(divisionId, patientId)
            if (result) return ResponseEntity.ok().body("Success")
            else return ResponseEntity.badRequest().body("Admitted patient not found")
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping("/division/{divisionId}/beds/createBed")
    fun addBed(@RequestBody bedInfo: BedCreationDto, @PathVariable divisionId: String): ResponseEntity<Any> {
        val bed: Bed?
        try{
            bed = pmsService.addBed(bedInfo,divisionId)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(bed)
    }

    @PatchMapping("/{staffId}/patient/update/{patientId}")
    fun updatePatient(
        @RequestBody patientInfo: PatientRegisterDto,
        @PathVariable("patientId") patientId: UUID,
        @PathVariable staffId: String
    ): ResponseEntity<Any> {
        try {
            val result = pmsService.updatePatient(patientInfo, patientId, staffId)
            if (result) return ResponseEntity.ok().body("Success")
            else return ResponseEntity.badRequest().body("Patient not found")
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping("/request/create/{patientId}/{divisionId}/{staffId}")
    fun requestPatientAdmission(
        @RequestBody requestInfo: RequestCreateDto,
        @PathVariable("patientId") patientId: UUID,
        @PathVariable("divisionId") divisionId: String,
        @PathVariable("staffId") staffId: String
    ): ResponseEntity<Any> {
        try {
            val result = pmsService.requestPatientAdmission(patientId, divisionId, staffId, requestInfo)
            if (result != null) return ResponseEntity.ok().body(result)
            else return ResponseEntity.badRequest().body("Invalid arguments")
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
    }

    @GetMapping("/division/{divisionId}/beds")
    fun getBeds(@PathVariable divisionId: String): ResponseEntity<Any> {
        val beds: List<BedMongoEntity>
        try{
            beds = pmsService.getAllBedsByDivision(divisionId)
        }
        catch (e: IllegalArgumentException){
            return ResponseEntity.badRequest().body("Error")
        }
        return ResponseEntity.ok().body(beds)
    }

    @GetMapping("/division/visualize/{divisionId}")
    fun visualizeDivision(@PathVariable("divisionId") divisionId: String): ResponseEntity<Any> {
        try {
            val divisionDto = pmsService.visualizeDivision(divisionId)
            return ResponseEntity.ok().body(divisionDto)
        } catch (e: IllegalArgumentException) {
            println(e)
            return ResponseEntity.badRequest().body("Error")
        }
    }
}