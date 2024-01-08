package seg3102.pms.adapters.repositories.converters
import org.mapstruct.Mapper
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.infrastructure.mongodb.entities.StaffAccountMongoEntity

@Mapper
interface StaffAccountMongoConverter {
    fun convertToMongo(staffAccount: StaffAccount): StaffAccountMongoEntity

    fun convertToModel(staffAccountMongo: StaffAccountMongoEntity): StaffAccount
}