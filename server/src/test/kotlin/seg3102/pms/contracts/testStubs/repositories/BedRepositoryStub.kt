package seg3102.pms.contracts.testStubs.repositories

import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.repositories.BedRepository
import java.util.*
import kotlin.collections.HashMap

class BedRepositoryStub: BedRepository {
    private val bedsByRoomAndBed: MutableMap<Pair<String, String>, Bed> = HashMap()
    private val bedsByPatientId: MutableMap<UUID, Bed> = HashMap()

    override fun save(bed: Bed): Bed {
        val key = Pair(bed.roomId, bed.bedId)
        if(bed.patientId != null){
            bedsByPatientId[bed.patientId!!] = bed
        }
        bedsByRoomAndBed[key] = bed
        return bed
    }

    override fun findByRoomIdAndBedId(roomId: String, bedId: String): Bed? {
        val key = Pair(roomId, bedId)
        return bedsByRoomAndBed[key]
    }

    override fun findByPatientId(patientId: UUID): Bed? = bedsByPatientId[patientId]
    override fun findAllByDivisionId(divisionId: String): List<Bed> {
        TODO("Not yet implemented")
    }
}


