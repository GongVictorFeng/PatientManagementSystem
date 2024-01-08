Feature: Prescribe Medication for a Patient
    Scenario 1: Doctor successfully prescribes medication
        Given Doctor is logged in
        And Patient is under Doctor's care
        When the Doctor asks to add a prescription
        Then HMS asks for required information
        When the Doctor enters patient's information
        Then HMS records prescription in Patient file
    
    Scenario 2: Selected Patient is not one of the Doctor's
        Given Doctor is logged in
        When the Doctor asks to add a prescription
        And the Patient is not under their care
        Then the HMS notifies the Doctor that the patient is not assigned to them

    Scenario 3: Doctor attempts to add incorrect prescription
        Given Doctor is logged in
        And Patient is under Doctor's care
        When the Doctor asks to add a prescription to the selected patient
        And the HMS asks for required information
        And the Doctor enters incorrect information
        Then the HMS displays an "Incorrect prescription" error message