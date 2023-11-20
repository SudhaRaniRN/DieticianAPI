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
      | Sheet1    |         0 |
      
@Logout
  Scenario: Check if User able to logout
    Given User creates GET Request for the API endpoint
    When User sends HTTPS Request with valid Url and valid endpoint
    Then User able to logout with response status 200 OK
