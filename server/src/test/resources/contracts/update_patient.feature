Feature: Update a Patient information
    Scenario 1: Medical Staff Member successfully updates Patient information
    Given Medical Staff Member is logged in
    And the Medical Staff Member is authorized
    When the Medical Staff Member modifies information
    And the Medical Staff Member resubmits the changes
    Then the HMS updates the Patient's registration information

  Scenario 2: Medical Staff Member does not have enough privilege to modify
    Given Medical Staff Member is logged in
    When the Medical Staff Member modifies information
    And the Medical Staff Member resubmits the changes
    Then the HMS displays a "Modification not allowed" error message