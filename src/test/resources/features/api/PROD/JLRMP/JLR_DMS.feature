Feature: JLR DMS

  Background:
    * print JLR_DMS_URL
    * url JLR_DMS_URL
    * def testSuite = 'prod/JLR_DMS'

  Scenario: 8.0.0 - GetGenericParts
    Given request read('prod/JLR_DMS/requests/GetGenericParts.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getGenericPartsResponse/genericPartsResponse/partsList/part/partNumber contains '5W30 STJLR.03.5003'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetGenericParts', testSuite)
    * assert result == true

  Scenario: 8.0.1 - GetJobAddOns
    Given request read('prod/JLR_DMS/requests/GetJobAddOns.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobAddOnsResponse/jobsResponse/jobHierarchy/operation/operation contains 'operation description="Remove &amp; Replace" id="11150005"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobAddOns', testSuite)
    * assert result == true

  Scenario: 8.0.2 - GetJobDetails_standard
    Given request read('prod/JLR_DMS/requests/GetJobDetails_standard.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains 'description="Thermostat, Remove &amp; Replace"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails_standard', testSuite)
    * assert result == true

  Scenario: 8.0.3 - GetJobDetails_JobConfigRule
    Given request read('prod/JLR_DMS/requests/GetJobDetails_JobConfigRule.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains 'job core="false" description="Automation Rule" id="110100055021" jobDifficulty="2" jobSource="LOC" priceFixedAt="INCLTAX" service="false"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails_JobConfigRule', testSuite)
    * assert result == true

  Scenario: 8.0.4 - GetJobDifficulties
    Given request read('prod/JLR_DMS/requests/GetJobDifficulties.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDifficultiesResponse/jobDifficultiesResponse contains 'jobDifficulty description="Normal"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDifficulties', testSuite)
    * assert result == true

  Scenario: 8.0.5 - GetJobs_AllJobs
    Given request read('prod/JLR_DMS/requests/GetJobs_AllJobs.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains '<operation description="Maintenance" id="10"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_AllJobs', testSuite)
    * assert result == true

  Scenario: 8.0.6 - GetJobs_MFCFiltered
    Given request read('prod/JLR_DMS/requests/GetJobs_MFCFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains 'id="101001705035"'
    And match response /Envelope/Body/getJobsResponse/jobsResponse !contains 'id="101006405243"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_MFCFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.7 - GetJobs_JobIDFiltered
    Given request read('prod/JLR_DMS/requests/GetJobs_JobIDFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse contains '<job core="true" description="(+) DPF. (-) Dynamic Response. (+) 1 Speed Transfer Case. (+) Standard Flow Twin Turbo. (+) 4 zone Air Conditioning. (+) FFBH  - FA999999" id="101016107178" jobDifficulty="2" jobSource="MAN" service="true"/>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_JobIDFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.8 - GetJobs_PartFiltered
    Given request read('prod/JLR_DMS/requests/GetJobs_PartFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains 'job core="true" description="(+) Generation 2 Dual Turbo" id="191001055082"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_PartFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.9 - GetJobs_LabourFiltered
    Given request read('prod/JLR_DMS/requests/GetJobs_LabourFiltered.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse contains 'job core="true" description="(+) Diesel Particle Filter. (+) Twin Turbo  - FA999999" id="101012905085'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs_LabourFiltered', testSuite)
    * assert result == true

  Scenario: 8.0.10 - GetVehicleFile
    Given request read('prod/JLR_DMS/requests/GetVehicleFile.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleFileResponse/vehicleFileResponse contains 'vehicleNumber="11"'
    And assert responseTime < 3000


    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleFile', testSuite)
    * assert result == true

  Scenario: 8.0.11 - GetVehicleInfo
    Given request read('prod/JLR_DMS/requests/GetVehicleInfo.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleInfoResponse/vehicleInfoResponse/vehicleInfo/vehicle contains 'modelDesc="L316 Defender'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleInfo', testSuite)
    * assert result == true