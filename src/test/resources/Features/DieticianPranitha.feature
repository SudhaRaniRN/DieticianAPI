#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
@pranitha
Feature: DieticianPranitha

  
  Background:
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber | 
      | Sheet1    |         1 |

 
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
   
@GetAllPatient_InvalidURL
 Scenario: To check if Dieticien can get all the patient data with Valid URL and Valid EndPoint.
 Given Dieticien create GET Request with Invalid URL
 When Dieticien send HTTPS Request
 Then Dieticien should not be logged-in and Response status code should be 404
 
 @GetAllPatient_Invalid_EndPoint
 Scenario: To check if Dieticien can get all the patient data with Valid URL and InValid EndPoint.
 Given Dieticien create GET Request with Invalid EndPoint
 When Dieticien send HTTPS Request
 Then Dieticien should not be logged-in and Response status code should be 404
 
  
    
 Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and request Body with mandatory, additional fields.
    Then Response status code should be 201 Created and response body contains created patient with details
    
    Examples:
   |Sheetname|rownumber|
   |Pranita|0|
  
  @tag2
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
 
 @deletepatient
  Scenario: Check if user able to delete a program with valid patient ID
   Given User creates DELETE Request for valid API endpoint  and  valid patientID
   When User sends HTTPS Request
   Then User receives 200 Ok status with message  
   
   @Logout
  Scenario: Check if User able to logout
    Given User creates GET Request for the API endpoint
    When User sends HTTPS Request with valid Url and valid endpoint
    Then User able to logout with response status 200 OK

    
    
