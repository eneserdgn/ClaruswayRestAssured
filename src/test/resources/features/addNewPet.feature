@ENDTOEND
Feature: Add a new pet to Store

  @Success1
  Scenario: Successful Operation - 200
    Given set baseURI "https://petstore.swagger.io/v2"
    Given set header "Content-Type", "application/json"
    Given set body for add a new pet to store 145782
    When send post request "/pet"
    Then check status code 200
    Then check time less than "2000"
    Then check response body add a new pet


  @Delete
  Scenario: Successful Operation - 200
    Given 145782 idli köpek oluşturulur
    When delete requesti çalıştırılır 145782
    Then responseun başarıyla geldiği kontrol edilir