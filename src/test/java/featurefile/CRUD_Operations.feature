Feature: To perform CRUD Operations

#Background: 
#Given The base URI is "http://localhost:3000/employees"

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario: To Perform POST operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the POST operation giving the Name as "Sharmi" and Salary as "5000"
    Then Response code should be 201

    Scenario: To perform the PUT operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the PUT operation giving the Name as "SSS" and Salary as "3000"
    Then Response code should be 200
    
    Scenario: To perform the DELETE operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the DELETE operation 
    Then Response code should be 200
