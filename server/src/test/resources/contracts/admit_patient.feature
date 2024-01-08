Feature: Admit patient to a division
  Scenario: add patient to a division
    Given the charge nurse is logged in
    And the division is not completed
    And the admission information is provided
    And the admission information includes existing and available Bed and Room
    When the application command addPatient is invoked
    Then a new admission is created
    And a new admission is added to division
    And a new admission is initialized from admission information
    And attribute occupancy status of bed was changed
    And patient is associated to bed
    And new log is created
    And attributes of log is initialized
    And patient is associated to log
    And staff is associated to log

