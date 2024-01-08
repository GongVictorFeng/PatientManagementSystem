package seg3102.pms.domain.division.facade.implementation

import seg3102.pms.application.dtos.queries.BedCreationDto
import seg3102.pms.application.dtos.queries.DivisionCreationDto
import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.application.dtos.queries.RequestCreateDto
import seg3102.pms.application.services.DomainEventEmitter
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.events.NewAdmissionAdded
import seg3102.pms.domain.division.events.NewRequestAdded
import seg3102.pms.domain.division.events.RequestUpdated
import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.division.factories.AdmissionFactory
import seg3102.pms.domain.division.factories.BedFactory
import seg3102.pms.domain.division.factories.DivisionFactory
import seg3102.pms.domain.division.factories.RequestFactory
import seg3102.pms.domain.division.repositories.AdmissionRepository
import seg3102.pms.domain.division.repositories.BedRepository
import seg3102.pms.domain.division.repositories.DivisionRepository
import seg3102.pms.domain.division.repositories.RequestRepository
import java.util.*
import kotlin.NoSuchElementException

class DivisionFacadeImpl(
    private var divisionRepository: DivisionRepository,
    private var divisionFactory: DivisionFactory,
    private var bedRepository: BedRepository,
    private var bedFactory: BedFactory,
    private var admissionFactory: AdmissionFactory,
    private var admissionRepository: AdmissionRepository,
    private var requestFactory: RequestFactory,
    private var requestRepository: RequestRepository,
    private var eventEmitter: DomainEventEmitter
):DivisionFacade {
    override fun isComplete(divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        if (division != null) {
            return division.complete
        }
        throw NoSuchElementException("Division with ID $divisionId not found")
    }

     override fun updateDivision(divisionId: String) {
         val division = divisionRepository.find(divisionId) ?: return
         division.updateAdmission()
         divisionRepository.save(division)
     }

    override fun getChargeNurse(divisionId: String): String? {
        val division = divisionRepository.find(divisionId) ?: return null
        return division.chargeNurseId
    }

    override fun getBedStatus(roomId: String, bedId: String): Boolean {
        val bed = bedRepository.findByRoomIdAndBedId(roomId, bedId)
        if (bed != null) {
            return bed.occupied
        }
        throw NoSuchElementException("$bedId bed in room $roomId not found")
    }

    override fun occupyBed(patientId: UUID, roomId: String, bedId: String) {
        val bed = bedRepository.findByRoomIdAndBedId(roomId, bedId)
        if (bed != null) {
            bed.occupy(patientId)
            bedRepository.deleteByRoomIdAndBedId(roomId, bedId)
            bedRepository.save(bed)
            return
        }
        throw NoSuchElementException("$bedId bed in room $roomId not found")
    }

    override fun createAdmission(divisionId: String, admissionInfo: PatientAdmissionDto): UUID {
        val admission = admissionFactory.createAdmission(divisionId, admissionInfo)
        println(admission)
        admissionRepository.save(admission)
        eventEmitter.emit(NewAdmissionAdded(UUID.randomUUID(),Date(),admission.id))
        return admission.id
    }

    override fun addBed(bedCreationDto: BedCreationDto, divisionId: String): Bed {
        val bed = bedFactory.createBed(bedCreationDto, divisionId)
        bedRepository.save(bed)
        return bed
    }

    override fun getAllBeds(divisionId: String): List<Bed> {
        return bedRepository.findAllByDivisionId(divisionId)
    }

    override fun addDivision(divisionCreationDto: DivisionCreationDto): Division? {
        val division = divisionFactory.createDivision(divisionCreationDto)
        divisionRepository.save(division)
        return division
    }

    override fun updateAdmissionForDischarge(patientId: UUID) {
        admissionRepository.deleteByPatientId(patientId)
    }

    override fun getAdmissionsOfDivision(divisionId: String): List<Admission> {
        return admissionRepository.findByDivisionId(divisionId)
    }

    override fun getRequestsOfDivision(divisionId: String): List<Request> {
        return requestRepository.findByDivisionId(divisionId)
    }

    override fun getDivision(divisionId: String): Division? {
        return divisionRepository.find(divisionId)
    }

    override fun getBed(patientId: UUID): Bed? {
        val bed = bedRepository.findByPatientId(patientId)
        if(bed != null){
            return bed
        }
        return null
    }

    override fun unoccupyBed(bed: Bed) {
        bed.unoccupy()
        bedRepository.deleteByRoomIdAndBedId(bed.roomId, bed.bedId)
        bedRepository.save(bed)
    }

    override fun updateDivisionForDischarge(divisionId: String) {
        val division = divisionRepository.find(divisionId)
        if (division != null) {
            division.updateDischarge()
            divisionRepository.save(division)
        }
    }

    override fun isInChargeOfDiv(staffId: String, divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        var inCharge = false
        if (division != null) {
            inCharge = division.isUnderChargeOf(staffId)
        }
        return inCharge
    }

    override fun getAdmissionByPatientId(patientId: UUID): Admission? {
        return admissionRepository.find(patientId)
    }

    override fun addRequest(patientId: UUID, divisionId: String, requestInfo: RequestCreateDto): UUID {
        val request = requestFactory.createRequest(patientId, divisionId, requestInfo)
        requestRepository.save(request)
        eventEmitter.emit(NewRequestAdded(UUID.randomUUID(), Date(), request.requestId))
        return request.requestId
    }

    override fun requestIsUnmarked(requestId: UUID): Boolean {
        val req = requestRepository.find(requestId)
        var isUnmarked = false
        if (req != null) {
            isUnmarked = req.isUnmarked()
        }
        return isUnmarked
    }

    override fun getRequestedDivision(requestId: UUID): String {
        val req = requestRepository.find(requestId)

        if (req != null) {
            return req.divisionId
        }
        throw NoSuchElementException("No such request")
    }

    override fun getRequestedPatient(requestId: UUID): UUID {
        val req = requestRepository.find(requestId)
        if (req != null) {
            return req.patientId
        }
        throw NoSuchElementException("No such request")
    }

    override fun acceptRequest(requestId: UUID) { 
        val req = requestRepository.find(requestId)
        if (req != null) {
            req.markAsAccepted()
            requestRepository.save(req)
            eventEmitter.emit(RequestUpdated(UUID.randomUUID(), Date(), requestId))
        }
    }
    
    override fun denyRequest(requestId: UUID) {
        val req = requestRepository.find(requestId)
        if (req != null) {
            req.markAsDenied()
            requestRepository.save(req)
            eventEmitter.emit(RequestUpdated(UUID.randomUUID(), Date(), requestId))
        }
    }
}