## Prescription Sub-Domain

- Support
- Prescription

<!-- UML Sequence Diagram


title Prescribe Medication - L2

participant Staff
participant PrescriptionFacade
participant PrescriptionFactory
participant PrescriptionRepository

Staff -> PrescriptionFacade:addPrescription(prescriptionInfo)

PrescriptionFacade -> PrescriptionFactory:p = createPrescription(prescriptionInfo)

PrescriptionFacade -> PrescriptionRepository:save(p)

Staff <<-- PrescriptionFacade:p.id

Staff -> PrescriptionFacade:getPrescriptionXX(prescriptionId)

PrescriptionFacade -> PrescriptionRepository:find(prescriptionId)?.XX

PrescriptionFacade <<-- PrescriptionRepository:Prescription.XX

Staff <- PrescriptionFacade:Prescription.XX

-->
