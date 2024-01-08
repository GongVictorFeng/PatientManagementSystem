package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3102.pms.adapters.repositories.converters.PrescriptionMongoConverter
import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.domain.prescription.repositories.PrescriptionRepository
import seg3102.pms.infrastructure.mongodb.dao.PrescriptionMongoRepository
import java.util.*

@Component
class PrescriptionMongoAdapter(private  val prescriptionMongoRepository: PrescriptionMongoRepository): PrescriptionRepository {
    private val converter = Mappers.getMapper(PrescriptionMongoConverter::class.java)
    override fun save(prescription: Prescription): Prescription {
        val prescriptionMongo = converter.convertToMongo(prescription)
        prescriptionMongoRepository.save(prescriptionMongo)
        return prescription
    }

    override fun find(id: UUID): Prescription? {
        val prescriptionMongo = prescriptionMongoRepository.findByIdOrNull(id)
        return prescriptionMongo?.let {converter.convertToModel(it)}
    }

    override fun findAllByPatientId(patientId: UUID): List<Prescription> {
        val prescriptionMongoList = prescriptionMongoRepository.findAllByPatientId(patientId)
        return prescriptionMongoList.map { converter.convertToModel(it) }
    }
}