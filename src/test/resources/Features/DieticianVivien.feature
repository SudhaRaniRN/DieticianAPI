
#@tag
#Feature: Deleting a patient
 #
#
  #Background:
  #Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    #Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    #When User sends HTTPS Request and  request Body with mandatory fields
    #Then User is able to login and response status code should be 200
#
    #Examples: 
      #| Sheetname | rownumber |
      #| Sheet1    |         2 |
#
  #@tag1
  #Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    #Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    #When User sends HTTPS Request and request Body with mandatory, additional fields.
    #Then Response status code should be 201 Created and response body contains created patient with details
    #
    #Examples:
   #|Sheetname|rownumber|
   #|Sheet1|2|
   #
   #
   #@delreq1
  #Scenario: Check if user able to delete a program with valid patient ID
    #Given User creates DELETE Request for valid API endpoint and valid patientID
    #When User sends HTTPS Request
    #Then User receives 204 Ok status with message
#
  #@delreq2
  #Scenario: Check if user able to delete a patient with valid API endpoint,invalid patientID
    #Given User creates DELETE Request for valid API endpoint and invalid patient ID
    #When User send HTTPS Request
    #Then User receives 400 Bad Request Status
#
  #@delreq3
  #Scenario: Check if  user able to delete a patient with invalid API endpoint and valid patientID
    #Given User creates DELETE Request for invalid API endpoint and valid patient ID
    #When The user sends HTTPS Request
    #Then User receives 404 Not Found Status
#
   @tag
Feature: Deleting a patient

  Background:
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         5 |

  @tag1
  Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and request Body with mandatory, additional fields.
    Then Response status code should be 201 Created and response body contains created patient with details
    
    Examples:
   |Sheetname|rownumber|
   |Sheet2|0|

   
   Scenario: Check if user able to delete a program with valid patient ID
   Given User creates DELETE Request for valid API endpoint  and  valid patientID
   When User sends HTTPS Request
   Then User receives 200 Ok status with message
   
   Scenario: Check if user able to delete a patient with valid API endpoint,invalid patientID
   Given User creates DELETE Request for valid API endpoint  and  invalid patient ID
   When User sends HTTPS Request with invalid PatientID
   Then User receives 400 Bad Request Status 
   
   Scenario: Check if  user able to delete a patient with invalid API endpoint and valid patientID
   Given User creates DELETE Request for invalid API endpoint and valid patient ID
   When User sends HTTPS Request with invalid endpoint
   Then User receives 404 Not Found Status