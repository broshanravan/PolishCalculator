Feature: Run scenarios for calculating results for calculationUtil java file

  Scenario: valid line Content Calculation
    Given The user enters a valid line
    When The calculation is requested
    Then the system will display calculation results

  Scenario: Invalid line content for calculation
    Given The user enters an invalid line
    When The invalid line calculation is requested
    Then The system throws an error

