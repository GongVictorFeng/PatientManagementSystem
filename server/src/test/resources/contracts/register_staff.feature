Feature: Register staff to the HMS (Nurse, Doctor, Medical Director, Personnel Officer)
  Scenario: add staff to the HMS
    Given the HMS is ON
    And provided staff information doesn't match an existing staff account
    When the application command registerStaff is invoked
    Then a new staff account is created
    And the new staff is initialized from the staff information
    And new Staff Role role was created
    And staff was associated to role 
