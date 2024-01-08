/*
package seg3102.pms.contracts.steps

import seg3102.pms.application.dtos.queries.*
import seg3102.pms.contracts.testStubs.repositories.BedRepositoryStub
import seg3102.pms.contracts.testStubs.repositories.DivisionRepositoryStub
import seg3102.pms.contracts.testStubs.repositories.StaffAccountRepositoryStub
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.ward.Bed
*/
/*

import seg3102.pms.contracts.testStubs.repositories.BedRepositoryStub
import seg3102.pms.contracts.testStubs.repositories.DivisionRepositoryStub
import seg3102.pms.contracts.testStubs.repositories.StaffAccountRepositoryStub
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.ward.Bed *//*


// Patient
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.entities.Address
import seg3102.pms.domain.patient.repositories.PatientRepository

// Division
//import seg3102.pms.domain.division.

// Prescription
import seg3102.pms.domain.prescription.entities.Prescription
import seg3102.pms.domain.prescription.repositories.PrescriptionRepository
import seg3102.pms.domain.staff.entities.StaffAccount

// Staff
//import seg3102.pms.domain.staff.

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import java.time.Year
import java.util.*


fun registerPatient(patientRepository: PatientRepository): Patient {
    val patientId = UUID.randomUUID()
    val address = Address("1000 Palladium", "Toronto", "Canada", "K1H 3E5")
    val patient = Patient(patientId,
        5678,
        "Nora",
        "Tata",
        address,
        "1234567890",
        LocalDateTime.now().minusYears(54),
        "M",
        "Married",
        "Dr.Phil")

    patientRepository.save(patient)
    return patient
}

fun setPatientInfo(): PatientRegisterDto {
    // val patientId = UUID.randomUUID()
    val address = Address("1000 Palladium", "Toronto", "Canada", "K1H 3E5")
    return PatientRegisterDto(
        5678,
        "Nora",
        "Tata",
        address,
        "1234567890",
        LocalDateTime.now().minusYears(54),
        "M",
        "Married",
        "Dr.Phil"
    )
}

fun setUpdatePatientInfo(): PatientRegisterDto {
    val address = Address("1000 Palladium_Updated", "Toronto_Updated", "Canada_Updated", "K1H 3E5_Updated")
    return PatientRegisterDto(
        5678,
        "NoraUpdated",
        "TataUpdated",
        address,
        "1234567890_Updated",
        LocalDateTime.now().minusYears(100),
        "M_Updated",
        "Married_Updated",
        "Dr.Phil_Updated"
    )
}


// fun addPrescription(prescriptionRepository: PrescriptionRepository): Prescription{
//     val prescriptionId = UUID.randomUUID()
//     val prescription = Prescription(
//         prescriptionId,
//         "123",
//         "X1",
//         "Xanax",
//         5,
//         2,
//         listOf("2 units at 9:30 AM", "3 units @ 7:00 PM"),
//         "By mouth",
//         LocalDateTime.now(),
//         LocalDateTime.now().plusDays(14)
//     )
//     prescriptionRepository.save(prescription)
//     return prescription
// }

fun createAccount(staffAccountRepository: StaffAccountRepositoryStub): StaffAccount {
    val acc = StaffAccount("userXXX",
        "Toto",
        "pass",
        "toto@somewhere.com")
    staffAccountRepository.save(acc)
    return acc
}

fun createDivision(divisionRepository: DivisionRepositoryStub): Division {
    val div = Division(
        1,
        "Orthopedic",
        "userXXX",
        "D Block",
        25,
        0,
        "9877"
    )
    divisionRepository.save(div)
    return div
}

fun setAdmissionInfo(): PatientAdmissionDto{
    val uuidString = "550e8400-e29b-41d4-a716-446655440000"
    val uuid = UUID.fromString(uuidString)
    return PatientAdmissionDto(
        "docXXX",
        1,
        1,
        uuid,
        "123456789")
}

fun createBed(bedRepository: BedRepositoryStub): Bed {
    val bed = Bed(
        1,
        1,
        null
    )
    bedRepository.save(bed)
    return bed
}
*/
