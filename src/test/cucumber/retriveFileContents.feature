Feature: The user attempts tp read input from a file

Scenario: Valid file Name path
Given The user provides a valid file name path
When The valid file name calculation is requested
Then the system will attempt to read the file and calculate each line

Scenario: Invalid file name path
Given The user provides an invalid name path for the file
When The invalid file name calculation is requested
Then The system throws an error
