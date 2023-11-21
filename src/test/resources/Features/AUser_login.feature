
@tag
Feature: POST REQUEST(User Login)

  @tag1
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         0 |
       | Sheet1    |         1 |
        | Sheet1    |         2 |
        
       
#@tag2
  #Scenario: Check if user able to create new patient with valid endpoint and request body (existing values)
     #Given User creates POST Request for the API endpoint
     #When User sends HTTPS Request and  request Body with mandatory , additional  fields.
     #Then Response status code should be 400 bad request and response body contains error message
     #
 #@tag3
   #Scenario: Check if user able to create new patient missing mandatory fields in request body
   #Given User creates POST Request for the API endpoint
   #When User sends HTTPS Request and request Body  (missing mandatory fields)
   #Then Response status code should be 400 bad request and response body contains error message
   #
  #@tag4
  #Scenario: Check if user able to create new patient with invalid endpoint
  #Given User creates POST Request for the API endpoint
  #When User send POST request with invalid endpoint
  #Then Response status code should be 404 Not Found and response body contains all the programs