package seg3102.pms.application.usecases.implementation

import seg3102.pms.application.dtos.queries.PatientRegisterDto
import seg3102.pms.application.usecases.RegisterPatient
import seg3102.pms.domain.patient.facade.PatientFacade
import java.util.*

class RegisterPatientImpl(
    private var patientFacade: PatientFacade): RegisterPatient
{
    override fun registerPatient(patientInfo: PatientRegisterDto): UUID?
    { 
         return patientFacade.registerPatient(patientInfo)
    }
}
 