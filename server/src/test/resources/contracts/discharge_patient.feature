Feature: Discharge patient from the hospital 
  Scenario: remove patient from the hospital
    Given the patient is admitted
    And the Charge Nurse is logged in
    When the application command dischargePatient is invoked
    Then a new patient account is discharged