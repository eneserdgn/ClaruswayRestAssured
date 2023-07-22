Feature: deneme

  Scenario:  Senaryo adı
    Given set baseURI ""
    Given set param "petId", "2"
    Given set queryParam "status", "available"
    Given set header "Content-Type", "application/json"
    Given set body ""
    When send get request ""
    When send post request ""
    When send put request ""
    When send delete request ""
    Then check status code 200
    Then check time less than "2000"
    Then check schema validation
    Then check body "name", "Karabaş"