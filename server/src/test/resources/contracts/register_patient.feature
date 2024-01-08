Feature: Register patient to the hospital
  Scenario: add patient to the hospital
    Given the medical staff member is logged in
    And provided patient information doesn't match an existing patient account
    When the application command registerPatient is invoked
    Then a new patient account is created
    And the new patient is initialized from the patient information
    And the new patient is issued a new indentification number
    