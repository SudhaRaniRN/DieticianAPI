Feature: Creating new patient
  I want to use this template for my feature file
  
  Background:
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         4 |

  

  @tag1
  Scenario: Get all the morbidities with expected response body
    Given User creates GET Request for the API endpoint to get all morbidities
    When User sends GET request
    Then Response status code should be 200 OK and response body contains all the morbidities

  @tag2
  Scenario: Check User able to get all the morbidities with Valid URL and invalid endpoint
    Given User sets valid URL and invalid endpoint
    When User sends GET request for invalid endpoint
    Then Response status code should be 404 Not Found and response body contains error message

    @tag3
  Scenario: Check if user is able to get morbidity by valid test name
    Given User sets valid URL and valid endpoint
    When User sends GET request with a valid test name
    Then Response status code should be 200 OK and response body contains morbidity searched for

  @tag4
  Scenario: Check if user is able to get morbidity by invalid test name
    Given User sets valid URL and valid getallmobidity
    When User sends GET request with an invalid test name
    Then Response status code for invalid test name should be 404 Not Found and response body contains error message
    
  @tag5
  Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and request Body with mandatory, additional fields.
    Then Response status code should be 201 Created and response body contains created patient with details
    
    Examples:
   |Sheetname|rownumber|
   |Sheet7|0|  

 
