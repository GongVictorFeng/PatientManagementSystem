Feature: Admit a patient from request
  Scenario: accept a patient admission request
    Given the charge nurse is logged in
    And the request is unmarked
    And the request is of the charge nurse's division
    And admission information is provided
    When the application command admitPatientFromRequest is invoked
    Then the request is marked as accepted
    And a new admission is created
    And the new admission is initialized from the admission information
    And the new admission is added to the division's admissions
    And a new log is created
    And patient is associated to the log
    And charge nurse is associated to the log

  Scenario: deny a patient admission request
    Given the charge nurse is logged in
    And the request is unmarked
    And the request is of the charge nurse's division
    And no admission information is provided
    When the application command admitPatientFromRequest is invoked
    Then request is marked as denied
    And a new log is created
    And patient is associated to the log
    And charge nurse is associated to the log