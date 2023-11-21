@Dieticien_Login
Feature: Title of your feature
  I want to use this template for my feature file

  Background:
  Scenario Outline: Check if User able to login with valid credentials,valid Url and Valid endpoint
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint with valid credentials
    When User sends HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         3 |

  @PostPatient
  Scenario Outline: Check if user able to create a new patient with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and request Body with mandatory, additional fields.
    Then Response status code should be 201 Created and response body contains created patient with details
    
    Examples:
   |Sheetname|rownumber|
   |Sheet1|2|
    
   @UserLogin_Patient
  Scenario Outline: Check if User is login as Dieticien able to login with Valid Credentials,valid Url and Valid endpoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User send HTTPS Request and  request Body with mandatory fields
    Then User is able to login and response status code should be 200 ok

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         9 |

 

    @Invalid_Password
    Scenario Outline: Check if User able to login as Dieticien with Invalid Password,valid Url and Valid endpoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When Send HTTPS Request and  request Body with mandatory fields
    Then User should not login and response status code should be 401

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         6 |
      
      
    @Invalid_EmailID
    Scenario Outline: Check if User able to login as Dieticien with Invalid email ID,valid Url and Valid endpoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When Send HTTPS Request and  request Body with mandatory fields
    Then User should not login and response status code should be 401

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         7 | 
      
    @Empty_Password
    Scenario Outline: Check if User able to login as Dieticien with Valid email ID & Empty Password
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When Send HTTPS Request and  request Body with mandatory fields
    Then User should not login and response status code should be 401

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         8 |  
      
      
    @InvalidURL
    Scenario Outline: Check if User able to login with Invalid URL & Valid EndPoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and  request Body with Invalid URL
    Then User should not be logged-in and response status code should be 404

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         5 |  
      
  @InvalidEndPoint
  Scenario Outline: Check if User is able to login with InValid endpoint
    Given Create POST Request "<Sheetname>" and <rownumber> for the API endpoint
    When User sends HTTPS Request and  request Body with Invalid Endpoint
    Then User should not login and response status code should be 401

    Examples: 
      | Sheetname | rownumber |
      | Sheet1    |         0 | 
      
      