Feature: Opel DMS

  Background:
    * url OPEL_DMS_URL
    * def testSuite = 'qa/Opel_DMS'

  Scenario: 8.0.0 - GetFleets
    Given request read('qa/Opel_DMS/requests/GetFleets.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getFleetsResponse/fleetsResponse/fleetList contains '<fleet fleetCode="GBFdummy01"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetFleets', testSuite)
    * assert result == true

  Scenario: 8.0.1 - GetGenericParts
    Given request read('qa/Opel_DMS/requests/GetGenericParts.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getGenericPartsResponse/genericPartsResponse/partsList/part/partNumber contains 'BRAKE_FLUID'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetGenericParts', testSuite)
    * assert result == true

  Scenario: 8.0.1 - GetGenericParts2
    Given request read('qa/Opel_DMS/requests/GetGenericParts2.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getGenericParts2Response/genericPartsResponse/partsList/part/partDescription contains 'BRAKE_FLUID'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetGenericParts2', testSuite)
    * assert result == true

  Scenario: 8.0.2 - GetJobAddOns
    Given request read('qa/Opel_DMS/requests/GetJobAddOns.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobAddOnsResponse/jobsResponse/jobHierarchy/operation/operation/operation contains '<job core="true" description="Initially after 3 years , then every second year"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobAddOns', testSuite)
    * assert result == true

  Scenario: 8.0.3 - GetJobDetails
    Given request read('qa/Opel_DMS/requests/GetJobDetails.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse/job contains 'description="Mileage Servicing, 20,000 Mls / 30,000 KM, MY11-"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails', testSuite)
    * assert result == true

  Scenario: 8.0.4 - GetJobDetails_MMRule
    Given request read('prod/Opel_DMS/requests/GetJobDetails_MMRule.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains '<job core="false" description="Air Filter, Remove &amp; Replace "'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails_MMRule', testSuite)
    * assert result == true


  Scenario: 8.0.5 - GetJobDifficulties
    Given request read('qa/Opel_DMS/requests/GetJobDifficulties.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDifficultiesResponse/jobDifficultiesResponse contains '<jobDifficulty description="Simple"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDifficulties', testSuite)
    * assert result == true

  Scenario: 8.0.6 - GetJobs
    Given request read('qa/Opel_DMS/requests/GetJobs.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains '<status description="OK" state="0"'
    And assert responseTime < 8000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs', testSuite)
    * assert result == true

  Scenario: 8.0.7 - GetJobs_POC
    Given request read('qa/Opel_DMS/requests/GetJobs_POC.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains 'id="09010015"'
    And match response /Envelope/Body/getJobsResponse/jobsResponse !contains 'id=""090100555005"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_POC', testSuite)
    * assert result == true

  Scenario: 8.0.8 - GetJobs_IDFiltered
    Given request read('qa/Opel_DMS/requests/GetJobs_IDFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/vehicle contains '<vinMatch>1G0R86E40CU111690</vinMatch>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_IDFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.9 - GetJobs_LabourFiltered
    Given request read('qa/Opel_DMS/requests/GetJobs_LabourFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/vehicle contains '<vinMatch>W0LPC6E61F8011393</vinMatch>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_LabourFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.10 - GetJobs_PartFiltered
    Given request read('qa/Opel_DMS/requests/GetJobs_PartFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/vehicle contains '<vinMatch>W0LPC6E61F8011393</vinMatch>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_PartFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.11 - GetJobs_DescriptionFiltered
    Given request read('qa/Opel_DMS/requests/GetJobs_DescriptionFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/jobHierarchy contains '<operation description="Servicing" id="05"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_DescriptionFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.12 - GetJobs_PredictedService
    Given request read('qa/Opel_DMS/requests/GetJobs_PredictedService.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/jobHierarchy contains '<operation description="Vauxhall Short Codes" id="92'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_PredictedService', testSuite)
    * assert result == true

  Scenario: 8.0.13 - GetVehicleFile
    Given request read('qa/Opel_DMS/requests/GetVehicleFile.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleFileResponse/vehicleFileResponse contains '<vehicleFileRecord bodyDesc="Panel Van"'

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleFile', testSuite)
    * assert result == true

  Scenario: 8.0.14 - GetVehicleInfo
    Given request read('qa/Opel_DMS/requests/GetVehicleInfo.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleInfoResponse/vehicleInfoResponse/vehicleInfo/vehicle contains '<vehicleFileRecord ModlCode="38"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleInfo', testSuite)
    * assert result == true