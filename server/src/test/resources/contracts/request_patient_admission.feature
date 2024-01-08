Feature: Request for admission of patient to a division
  Scenario: create a request for admission of patient to a division
    Given the charge nurse is logged in
    And charge nurse is associated to the target division
    And patient is not admitted
    And request information is provided
    When the application command requestPatientAdmission is invoked
    Then a new request is created
    And the new request is initialized from the request information
    And the new request is added to the division's requests
    And a new log is created
    And patient is associated to the log
    And charge nurse is associated to the log