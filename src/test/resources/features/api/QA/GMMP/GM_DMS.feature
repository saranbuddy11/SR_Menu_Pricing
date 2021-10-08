Feature: GM DMS

  Background:
    * configure headers = {ldap_bac: 'USdummy01', TP_ID: 'FS_DMS'}
    * url GM_DMS_URL
    * print url
    * def testSuite = 'qa/GM_DMS'

  Scenario: 7.0.1 - GetGenericParts2
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetGenericParts2', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetGenericParts2.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getGenericParts2Response/genericPartsResponse/partsList contains '<partDescription>REFRIGERANT</partDescription>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetGenericParts2', testSuite)
    * assert result == true

  Scenario: 7.0.2 - GetJobAddOns
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobAddOns', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobAddOns.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobAddOnsResponse/jobsResponse contains 'id="080100025024"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobAddOns', testSuite)
    * assert result != true

  Scenario: 7.0.3 - GetJobsDetails
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobDetail', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobDetail.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse/job/partsList/part/partNumber contains '84259368'
    And assert responseTime < 16000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetails', testSuite)
    * assert result ==true

  Scenario: 7.0.4 - GetJobDifficulties
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobDifficulties', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobDifficulties.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDifficultiesResponse/jobDifficultiesResponse contains '<jobDifficulty description="Simple"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDifficulties', testSuite)
    * assert result == true

  Scenario: 7.0.5 - GetJobs
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobs', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobs.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobsResponse/jobsResponse/jobHierarchy contains '<job core="true" id="066001045058" jobDifficulty="1" jobSource="MAN" oe="false" service="false"/>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobs', testSuite)
    * assert result == true

  Scenario: 7.0.6 - GetVehicleInfo
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetVehicleInfo', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetVehicleInfo.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleInfoResponse/vehicleInfoResponse/vehicleInfo/vehicle contains 'bodyType="10434"'
    And assert responseTime < 4000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleInfo', testSuite)
    * assert result == true

  Scenario: 7.0.7 - GetVehicleId
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetVehicleId', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetVehicleId.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVehicleIdResponse/vehicleIdResponse/manualMatchVehicle contains 'vehicleNumber="317944"'
    And assert responseTime < 4000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVehicleId', testSuite)
    * assert result == true

  Scenario: 7.0.8 - GetCusType
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetCusType', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetCusType.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getCusTypeResponse/cusTypeResponse contains '<cusTypeRecord ctDesc='
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetCusType', testSuite)
    * assert result == true

  Scenario: 7.0.9 - GetShell
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetShell', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetShell.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getShellResponse/shellResponse contains '<status description="OK" state="0"/>'
    And match response /Envelope/Body/getShellResponse/shellResponse contains '<shellRecord description='
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetShell', testSuite)
    * assert result == true

  Scenario: 7.0.10 - GetVisitJobs
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetVisitJobs', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetVisitJobs.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getVisitJobsResponse/visitJobsResponse contains '<status description="OK" state="0"/>'
    And assert responseTime < 16000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetVisitJobs', testSuite)
    * assert result == true

  Scenario: 7.0.11 - GetQuoteSettings
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetQuoteSettings', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetQuoteSettings.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getQuoteSettingsResponse/quoteSettingsResponse contains '<status description="OK" state="0" vehicleFileVersion='
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetQuoteSettings', testSuite)
    * assert result == true