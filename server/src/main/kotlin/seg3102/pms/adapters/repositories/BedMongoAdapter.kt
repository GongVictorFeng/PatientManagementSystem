package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component
import seg3102.pms.adapters.repositories.converters.BedMongoConverter
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.repositories.BedRepository
import seg3102.pms.infrastructure.mongodb.dao.BedMongoRepository
import java.util.*

@Component
class BedMongoAdapter(private val bedRepository: BedMongoRepository): BedRepository {
    private val converter = Mappers.getMapper(BedMongoConverter::class.java)

    override fun findByRoomIdAndBedId(roomId: String, bedId: String): Bed? {
        val bedMongo = bedRepository.findByRoomIdAndBedId(roomId,bedId)
        return bedMongo?.let { converter.convertToModel(it) }
    }

    override fun deleteByRoomIdAndBedId(roomId: String, bedId: String) {
        return bedRepository.deleteByRoomIdAndBedId(roomId, bedId)
    }

    override fun findByPatientId(patientId: UUID): Bed? {
        val bedMongo = bedRepository.findByPatientId(patientId)
        return bedMongo?.let { converter.convertToModel(it) }
    }

    override fun findAllByDivisionId(divisionId: String): List<Bed> {
        val bedMongoList = bedRepository.findAllByDivisionId(divisionId)
        return bedMongoList.map {converter.convertToModel(it)}
    }

    override fun save(bed: Bed): Bed {
        val bedMongo = converter.convertToMongo(bed)
        bedRepository.save(bedMongo)
        return bed
    }
}