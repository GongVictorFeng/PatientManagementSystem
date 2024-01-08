package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component
import org.springframework.data.repository.findByIdOrNull

import seg3102.pms.adapters.repositories.converters.RequestMongoConverter
import seg3102.pms.domain.division.entities.Request
import seg3102.pms.domain.division.repositories.RequestRepository
import seg3102.pms.infrastructure.mongodb.dao.RequestMongoRepository
import seg3102.pms.infrastructure.mongodb.entities.division.RequestMongoEntity

import java.util.UUID

@Component
class RequestMongoAdapter(private val requestRepository: RequestMongoRepository): RequestRepository {
    private val converter = Mappers.getMapper(RequestMongoConverter::class.java)

    override fun save(request: Request): Request {
        val requestMongo = converter.convertToMongo(request)
        requestRepository.save(requestMongo)
        return request
    }

    override fun find(requestId: UUID): Request? {
        val requestMongo = requestRepository.findByIdOrNull(requestId)
        return requestMongo?.let {converter.convertToModel(it)}
    }

    override fun findByDivisionId(divisionId: String): List<Request> {
        val requestMongoEntities: List<RequestMongoEntity> = requestRepository.findByDivisionId(divisionId)
        return converter.convertListToModels(requestMongoEntities)
    }

    override fun findByPatientId(patientId: UUID): Request? {
        val requestMongo = requestRepository.findByPatientId(patientId)
        return requestMongo?.let {converter.convertToModel(it)}
    }
}