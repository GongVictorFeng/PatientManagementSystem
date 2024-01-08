package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.entities.Address
import java.util.UUID

@Mapper
interface PatientDtoConverter {
    @Mappings(
        Mapping(target = "address.street", source = "patientDto.street"),
        Mapping(target = "address.city", source = "patientDto.city"),
        Mapping(target = "address.country", source = "patientDto.country"),
        Mapping(target = "address.postalCode", source = "patientDto.postalCode"),
        Mapping(target = "dateOfBirth", source = "patientDto.dateOfBirth", dateFormat = "yyyy-MM-dd"),
        Mapping(target = "nextOfKin.name", source = "patientDto.nokName"),
        Mapping(target = "nextOfKin.relation", source = "patientDto.nokRelation"),
        Mapping(target = "nextOfKin.address.street", source = "patientDto.nokStreet"),
        Mapping(target = "nextOfKin.address.city", source = "patientDto.nokCity"),
        Mapping(target = "nextOfKin.address.country", source = "patientDto.nokCountry"),
        Mapping(target = "nextOfKin.address.postalCode", source = "patientDto.nokPostalCode"),
        Mapping(target = "nextOfKin.phoneNum", source = "patientDto.nokPhoneNum")
    )
    fun convertDto(patientDto: PatientRegisterDto, id: UUID): Patient

    // This isn't working...
    // fun addressMap(street: String, city: String, country: String, postalCode: String): Address {
    //     return Address(street, city, country, postalCode)
    // }
}
