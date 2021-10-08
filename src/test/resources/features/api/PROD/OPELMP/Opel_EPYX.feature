Feature: Opel EPYX

  Background:
    * url OPEL_EPYX_URL
    * def testSuite = 'prod/Opel_EPYX'

  Scenario: 8.1.0 - GetJobDetails
    Given request read('prod/Opel_EPYX/requests/GetJobDetails.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/JobDetailsOutput/JobDetailed/ICMEJobCode contains '90058'
    And assert responseTime < 30000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails', testSuite)
    * assert result == true

  Scenario: 8.1.1 - GetSearchList
    Given request read('prod/Opel_EPYX/requests/GetSearchList.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/SearchListOutput/Job/ID contains '188027'
    And assert responseTime < 30000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetSearchList', testSuite)
    * assert result == true

  Scenario: 8.1.2 - GetVehicleDetails
    Given request read('prod/Opel_EPYX/requests/GetVehicleDetails.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/VehicleDetailsOutput/Vehicle/CliffordThamesVehicleID contains 'W0L0AHM757G028179'
    And assert responseTime < 30000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleDetails', testSuite)
    * assert result == true