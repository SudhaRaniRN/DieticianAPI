
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background:
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber |
      | Sheet1   |         5 |
      
      Scenario: Get all the morbidities with expected response body
    Given User creates GET Request for the API endpoint to get all morbidities
    When User sends GET request
    Then Response status code should be 200 OK and response body contains all the morbidities


Scenario: Check if user is able to get morbidity by valid test name
    Given User sets valid URL and valid endpoint
    When User sends GET request with a valid test name
    Then Response status code should be 200 OK and response body contains morbidity searched for
    
    
    @GetAllPatient_ValidURL_ValidEndPoint
Scenario: To check if Dieticien can get all the patient data with Valid URL and Valid EndPoint. 
Given Dieticien create GET Request for the API endpoint
When Dieticien send HTTPS Request
Then Dieticien get all Patient details and Response status code should be 200 ok


  @tag1
  Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and request Body with mandatory, additional fields.
    Then Response status code should be 201 Created and response body contains created patient with details
    
    Examples:
   |Sheetname|rownumber|
   |Vivien|0|

 Scenario Outline: Check if user able to update a patient with valid PatientID and mandatory request body
   Given User creates PUT Request "<Sheetname>" and <rownumber> for the API endpoint with Valid patientId
   When User sends HTTPS Request  and  request Body with mandatory, additional  fields
   Then User receives 200 OK Status with updated value in response body
    Examples:
   |Sheetname|rownumber|
   |PriteeUpt   |0        |
   
   @UserLogin_Patient
  Scenario Outline: Check if User is login as Patient able to login with Valid Credentials,valid Url and Valid endpoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User send HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200 ok

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         9 |
   
   Scenario: Check if user able to delete a patient with valid API endpoint,invalid patientID
   Given User creates DELETE Request for valid API endpoint  and  invalid patient ID
   When User sends HTTPS Request with invalid PatientID
   Then User receives 400 Bad Request Status 
   
   Scenario: Check if  user able to delete a patient with invalid API endpoint and valid patientID
   Given User creates DELETE Request for invalid API endpoint and valid patient ID
   When User sends HTTPS Request with invalid endpoint
   Then User receives 404 Not Found Status
   
   Scenario: Check if user able to delete a program with valid patient ID
   Given User creates DELETE Request for valid API endpoint  and  valid patientID
   When User sends HTTPS Request
   Then User receives 200 Ok status with message
   
   Scenario: Check if User able to logout
    Given User creates GET Request for the API endpoint
    When User sends HTTPS Request with valid Url and valid endpoint
    Then User able to logout with response status 200 OK