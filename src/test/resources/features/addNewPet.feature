Feature: Add a new pet to Store

  @Success
  Scenario: Successful Operation - 200
    Given set baseURI "https://petstore.swagger.io/v2"
    Given set body for add a new pet to store
    When send post request "/pet"
    Then check status code 200
    Then check time less than "2000"
