Feature: Finds pet by status

  @Success
  Scenario: Successful Operation - 200
    Given set baseURI "https://petstore.swagger.io/v2"
    Given set queryParam "status", "available"
    When send get request "/pet/findByStatus"
    Then check status code 200
    Then check time less than "2000"

  Scenario: Invalid Status Value - 400
    Given set baseURI "https://petstore.swagger.io/v2"
    Given set queryParam "status", "||"
    When send get request "/pet/findByStatus"
    Then check status code 200
    Then check time less than "2000"