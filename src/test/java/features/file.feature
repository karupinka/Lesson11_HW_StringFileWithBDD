
Feature: Control of file creation

@File
Scenario: Checking the creation of the default file
    Given User want to create default file
    When User create FileTask object and use createFile method
    Then File has been created

