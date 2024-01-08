package seg3102.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3102.pms.adapters.repositories.converters.StaffAccountMongoConverter
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.staff.repositories.StaffAccountRepository
import seg3102.pms.infrastructure.mongodb.dao.StaffAccountMongoRepository

@Component
class StaffAccountMongoAdapter(private val staffRepository: StaffAccountMongoRepository): StaffAccountRepository {
    private val converter = Mappers.getMapper(StaffAccountMongoConverter::class.java)

    override fun find(employeeNumber: String): StaffAccount? {
        val staffAccountMongo = staffRepository.findByIdOrNull(employeeNumber)
        return staffAccountMongo?.let { converter.convertToModel(it) }
    }

    override fun save(staffAccount: StaffAccount): StaffAccount {
        val staffAccountMongo = converter.convertToMongo(staffAccount)
        staffRepository.save(staffAccountMongo)
        return staffAccount
    }

    override fun findByName(name: String): StaffAccount? {
        val staffAccountMongo = staffRepository.findByName(name)
        return staffAccountMongo?.let { converter.convertToModel(it) }
    }

    override fun delete(employeeNumber: String): Boolean {
        staffRepository.deleteById(employeeNumber)
        return true
    }

    override fun findAll(): List<StaffAccount> {
        val staffAccountMongoList = staffRepository.findAll()
        return staffAccountMongoList.map { converter.convertToModel(it) }
    }
}