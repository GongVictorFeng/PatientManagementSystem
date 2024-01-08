package seg3102.pms.domain.division.repositories

import seg3102.pms.domain.division.entities.ward.Bed
import java.util.UUID

interface BedRepository {
    fun findByRoomIdAndBedId(roomId: String, bedId: String): Bed?
    fun deleteByRoomIdAndBedId(roomId: String, bedId: String)
    fun findByPatientId(patientId: UUID): Bed?

    fun findAllByDivisionId(divisionId: String): List<Bed>
    fun save(bed: Bed): Bed
}