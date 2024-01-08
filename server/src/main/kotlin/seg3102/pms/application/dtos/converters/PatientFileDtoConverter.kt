package seg3102.pms.application.dtos.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3102.pms.application.dtos.responses.PatientFileDto
import seg3102.pms.domain.patient.entities.Patient

@Mapper
interface PatientFileDtoConverter {
    @Mappings(
        Mapping(target = "street", source = "patient.address.street"),
        Mapping(target = "city", source = "patient.address.city"),
        Mapping(target = "country", source = "patient.address.country"),
        Mapping(target = "postalCode", source = "patient.address.postalCode"),
        Mapping(target = "dateOfBirth", source = "patient.dateOfBirth"),
        Mapping(target = "nokName", source = "patient.nextOfKin.name"),
        Mapping(target = "nokRelation", source = "patient.nextOfKin.relation"),
        Mapping(target = "nokStreet", source = "patient.nextOfKin.address.street"),
        Mapping(target = "nokCity", source = "patient.nextOfKin.address.city"),
        Mapping(target = "nokCountry", source = "patient.nextOfKin.address.country"),
        Mapping(target = "nokPostalCode", source = "patient.nextOfKin.address.postalCode"),
        Mapping(target = "nokPhoneNum", source = "patient.nextOfKin.phoneNum")
    )
    fun convertToDto(patient: Patient): PatientFileDto
}