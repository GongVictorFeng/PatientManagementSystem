package seg3102.pms.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.assertj.core.api.Assertions
import seg3102.pms.application.dtos.queries.PatientAdmissionDto
import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.application.usecases.AdmitPatient
import seg3102.pms.application.usecases.RegisterPatient
import seg3102.pms.application.usecases.implementation.AdmitPatientImpl
import seg3102.pms.application.usecases.implementation.RegisterPatientImpl
import seg3102.pms.contracts.testStubs.factories.AdmissionFactoryStub
import seg3102.pms.contracts.testStubs.factories.LogFactoryStub
import seg3102.pms.contracts.testStubs.factories.PatientFactoryStub
import seg3102.pms.contracts.testStubs.factories.RequestFactoryStub
import seg3102.pms.contracts.testStubs.repositories.*
import seg3102.pms.contracts.testStubs.services.EventEmitterStub
import seg3102.pms.domain.division.entities.Admission
import seg3102.pms.domain.staff.entities.StaffAccount
import seg3102.pms.domain.division.entities.Division
import seg3102.pms.domain.division.entities.ward.Bed
import seg3102.pms.domain.division.facade.implementation.DivisionFacadeImpl
import seg3102.pms.domain.log.entities.Log
import seg3102.pms.domain.log.facade.implementation.LogFacadeImpl
import seg3102.pms.domain.patient.entities.Patient
import seg3102.pms.domain.patient.facade.implementation.PatientFacadeImpl
import java.util.UUID

class StepsDefinition: En {
    private var staffAccountRepository = StaffAccountRepositoryStub()
    private var admissionFactory = AdmissionFactoryStub()
    private var admissionRepository = AdmissionRepositoryStub()
    private var divisionRepository = DivisionRepositoryStub()
    private var patientRepository = PatientRepositoryStub()
    private var patientFactory = PatientFactoryStub()
    private var bedRepository = BedRepositoryStub()
    private var logRepository = LogRepositoryStub()
    private var logFactory = LogFactoryStub()
    private var requestFactory = RequestFactoryStub()
    private var requestRepository = RequestRepositoryStub()
    private var eventEmitter = EventEmitterStub()

    private var chargeNurse: StaffAccount? = null
    private var division: Division? = null
    private var admissionInfo: PatientAdmissionDto? = null
    private var bed: Bed? = null
    private var isAdmit: Boolean = false
    private var newAdmissionId: UUID? = null
    private var newAdmission: Admission? = null
    private var newLogId: UUID? = null
    private var newLog: Log? = null
    private var patientInfo: PatientRegisterDto? = null
    private var newPatientId: UUID? = null
    private var newPatient: Patient? =null

    init {
        Given("the charge nurse is logged in"){
            chargeNurse = createAccount(staffAccountRepository)
            Assertions.assertThat(chargeNurse).isNotNull
        }

        Given("the division is not completed"){
            division = createDivision(divisionRepository)
            Assertions.assertThat(division).isNotNull
            Assertions.assertThat(division?.complete).isFalse()
        }

        Given("the admission information is provided"){
            admissionInfo = setAdmissionInfo()
            Assertions.assertThat(admissionInfo).isNotNull
        }

        Given("the admission information includes existing and available Bed and Room"){
            bed = createBed(bedRepository)
            Assertions.assertThat(bed?.patientId).isNull()
            Assertions.assertThat(bed?.occupied).isFalse()
        }

        Given("the medical staff member is logged in") {
            chargeNurse = createAccount(staffAccountRepository)
            Assertions.assertThat(chargeNurse).isNotNull
        }

        Given("provided patient information doesn't match an existing patient account") {
            patientInfo = setPatientInfo()
            Assertions.assertThat(patientInfo).isNotNull
        }

        When("the application command registerPatient is invoked") {
            val patientFacade = PatientFacadeImpl(patientRepository,
                patientFactory,
                eventEmitter)
            val uc: RegisterPatient = RegisterPatientImpl(
                patientFacade
            )
            newPatientId = patientInfo?.let { uc.registerPatient(it) }

        }

        
        When("the application command addPatient is invoked"){
            val divisionFacade = DivisionFacadeImpl(
                divisionRepository,
                bedRepository,
                admissionFactory,
                admissionRepository,
                requestFactory,
                requestRepository,
                eventEmitter
            )
            val logFacade = LogFacadeImpl(
                logRepository,
                logFactory,
                eventEmitter
            )
            val uc: AdmitPatient = AdmitPatientImpl(divisionFacade, logFacade)
            isAdmit = division?.let { division ->
                admissionInfo?.let { admissionInfo ->
                    uc.addPatient(division.divisionId, admissionInfo)
                }
            } ?: false
        }

        Then("a new patient account is created") {
            Assertions.assertThat(newPatientId).isNotNull
        }

        Then("the new patient is initialized from the patient information") {
            newPatient = newPatientId?.let { patientRepository.find(it) }
            Assertions.assertThat(newPatient).isNotNull
        }
        Then("the new patient is issued a new indentification number") {
            Assertions.assertThat(newPatient?.insuranceNum).isEqualTo(patientInfo?.insuranceNum)
        }

        Then("a new admission is created"){
            newAdmissionId = eventEmitter.retrieveNewAdmissionAddedEvent().admissionId
            Assertions.assertThat(newAdmissionId).isNotNull()
        }
        Then("a new admission is initialized from admission information"){
            newAdmission = newAdmissionId?.let { admissionRepository.find(it) }
            Assertions.assertThat(newAdmission).isNotNull
            Assertions.assertThat(newAdmission?.localDoctor).isEqualTo(admissionInfo?.localDoctor)
        }
        Then("a new admission is added to division"){
            Assertions.assertThat(division?.admissions?.get(0)).isNotNull
        }
        Then("attribute occupancy status of bed was changed"){
            Assertions.assertThat(bed?.occupied).isTrue()
        }
        Then("patient is associated to bed"){
            Assertions.assertThat(bed?.patientId).isNotNull()
        }
        Then("new log is created"){
            newLogId = eventEmitter.retrieveNewLogAddedEvent().logId
            Assertions.assertThat(newLogId).isNotNull()
        }
        Then("attributes of log is initialized"){
            newLog = newLogId?.let { logRepository.find(it)}
            Assertions.assertThat(newLog).isNotNull
            Assertions.assertThat(newLog?.operation).isEqualTo("admit patient")
        }
        Then("patient is associated to log"){
            Assertions.assertThat(newLog?.patient).isEqualTo(admissionInfo?.patientId)
        }
        Then("staff is associated to log"){
            Assertions.assertThat(newLog?.staff).isEqualTo(division?.chargeNurseId)
        }
        After { _: Scenario ->
            admissionFactory = AdmissionFactoryStub()
            admissionRepository = AdmissionRepositoryStub()
            divisionRepository = DivisionRepositoryStub()
            patientRepository = PatientRepositoryStub()
            patientFactory = PatientFactoryStub()
            bedRepository = BedRepositoryStub()
            logRepository = LogRepositoryStub()
            logFactory = LogFactoryStub()
            eventEmitter = EventEmitterStub()
            staffAccountRepository = StaffAccountRepositoryStub()

            chargeNurse = null
            division = null
            admissionInfo = null
            bed = null
            isAdmit = false
            newAdmissionId = null
            newAdmission = null
            newLogId = null
            newLog = null
            patientInfo = null
            newPatientId = null
            newPatient = null
        }
    }
}