Feature: Control of file creation

  @File
  Scenario Outline: Checking the creation of the file with Names
    Given User want to create file with name <Name> in folder
    When User create FileTask object  and use createFile method with Constructor with String parametr
    Then File has been created with user name

    Examples:
      | Name    |
      | "Cat"    |
      | "Dog"    |
      | "Parrot" |