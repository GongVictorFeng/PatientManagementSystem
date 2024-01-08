package seg3102.pms.infrastructure.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import seg3102.pms.application.dtos.queries.*
import seg3102.pms.application.usecases.*
import seg3102.pms.application.usecases.implementation.*
import seg3102.pms.application.services.DomainEventEmitter

import seg3102.pms.domain.division.facade.DivisionFacade
import seg3102.pms.domain.division.facade.implementation.DivisionFacadeImpl
import seg3102.pms.domain.division.repositories.*
import seg3102.pms.domain.division.factories.*

import seg3102.pms.domain.log.facade.LogFacade
import seg3102.pms.domain.log.facade.implementation.LogFacadeImpl
import seg3102.pms.domain.log.repositories.*
import seg3102.pms.domain.log.factories.*

import seg3102.pms.domain.patient.facade.PatientFacade
import seg3102.pms.domain.patient.facade.implementation.PatientFacadeImpl
import seg3102.pms.domain.patient.repositories.*
import seg3102.pms.domain.patient.factories.*

import seg3102.pms.domain.prescription.facade.PrescriptionFacade
import seg3102.pms.domain.prescription.facade.implementation.PrescriptionFacadeImpl
import seg3102.pms.domain.prescription.repositories.*
import seg3102.pms.domain.prescription.factories.*

import seg3102.pms.domain.staff.facade.StaffFacade
import seg3102.pms.domain.staff.facade.implementation.StaffFacadeImpl
import seg3102.pms.domain.staff.repositories.*
import seg3102.pms.domain.staff.factories.*


@Configuration
class BeanConfiguration() {
    // Use cases
    @Bean
    fun admitPatientUseCase(divisionFacade: DivisionFacade, logFacade: LogFacade): AdmitPatient {
        return AdmitPatientImpl(divisionFacade, logFacade)
    }

    @Bean
    fun admitPatientFromRequestUseCase(
        divisionFacade: DivisionFacade,
        logFacade: LogFacade,
        admitPatient: AdmitPatient
    ): AdmitPatientFromRequest {
        return AdmitPatientFromRequestImpl(divisionFacade,logFacade, admitPatient)
    }

    @Bean
    fun dischargePatientUseCase(divisionFacade: DivisionFacade, logFacade: LogFacade): DischargePatient {
        return DischargePatientImpl(divisionFacade, logFacade)
    }

    @Bean
    fun prescribePrescriptionUseCase(
        prescriptionFacade: PrescriptionFacade,
        logFacade: LogFacade
    ): PrescribePrescription {
        return PrescribePrescriptionImpl(prescriptionFacade, logFacade)
    }

    @Bean
    fun consultPatientFile(patientFacade: PatientFacade, logFacade: LogFacade): ConsultPatientFile {
        return ConsultPatientFileImpl(patientFacade, logFacade)
    }

    @Bean
    fun registerPatientUseCase(patientFacade: PatientFacade): RegisterPatient {
        return RegisterPatientImpl(patientFacade)
    }

    @Bean
    fun registerStaffUseCase(staffFacade: StaffFacade): RegisterStaff {
        return RegisterStaffImpl(staffFacade)
    }

    @Bean
    fun staffLoginUseCase(staffFacade: StaffFacade): StaffLogin {
        return StaffLoginImpl(staffFacade)
    }

    @Bean
    fun createBedUseCase(divisionFacade: DivisionFacade): CreateBed {
        return CreateBedImpl(divisionFacade)
    }

    @Bean
    fun createDivision(divisionFacade: DivisionFacade): CreateDivision{
        return CreateDivisionImpl(divisionFacade)
    }

    @Bean
    fun requestPatientAdmissionUseCase(
        staffFacade: StaffFacade,
        divisionFacade: DivisionFacade,
        logFacade: LogFacade
    ): RequestPatientAdmission {
        return RequestPatientAdmissionImpl(staffFacade, divisionFacade, logFacade)
    }

    @Bean
    fun updatePatientUseCase(
        patientFacade: PatientFacade,
        logFacade: LogFacade
    ): UpdatePatient {
        return UpdatePatientImpl(patientFacade, logFacade)
    }

    @Bean
    fun visualizeDivision(divisionFacade: DivisionFacade): VisualizeDivision {
        return VisualizeDivisionImpl(divisionFacade)
    }

    // Facades
    @Bean
    fun divisionFacade(
        divisionRepository: DivisionRepository,
        divisionFactory: DivisionFactory,
        bedRepository: BedRepository,
        bedFactory: BedFactory,
        admissionFactory: AdmissionFactory,
        admissionRepository: AdmissionRepository,
        requestFactory: RequestFactory,
        requestRepository: RequestRepository,
        eventEmitter: DomainEventEmitter
    ): DivisionFacade {
        return DivisionFacadeImpl(
            divisionRepository,
            divisionFactory,
            bedRepository,
            bedFactory,
            admissionFactory,
            admissionRepository,
            requestFactory,
            requestRepository,
            eventEmitter
        )
    }

    @Bean
    fun logFacade(
         logRepository: LogRepository,
         logFactory: LogFactory,
        eventEmitter: DomainEventEmitter
    ): LogFacade {
        return LogFacadeImpl(logRepository, logFactory, eventEmitter)
    }
    
    @Bean
    fun patientFacade(
        patientRepository: PatientRepository,
        patientFactory: PatientFactory,
        eventEmitter: DomainEventEmitter
    ): PatientFacade {
        return PatientFacadeImpl(patientRepository, patientFactory, eventEmitter)
    }

    @Bean
    fun prescriptionFacade(
        prescriptionFactory: PrescriptionFactory,
         prescriptionRepository: PrescriptionRepository,
         eventEmitter: DomainEventEmitter
     ): PrescriptionFacade {
        return PrescriptionFacadeImpl(prescriptionFactory, prescriptionRepository, eventEmitter)
    }

    @Bean
    fun staffFacade(
        staffRepository: StaffAccountRepository,
        staffFactory: StaffFactory,
        eventEmitter: DomainEventEmitter
    ): StaffFacade {
        return StaffFacadeImpl(staffRepository, staffFactory, eventEmitter)
    }

}