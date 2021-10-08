Feature: GM DMS NRP

  Background:
    * url GM_DMS_URL
    * print url
    * def testSuite = 'prod/GM_DMS'

  Scenario: GetJobDetailsNRP1_Replace_Cabin_Filter
    * configure headers = {ldap_bac: '269449', TP_ID: 'FS_DMS'}
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobDetailsNRP1ReplaceCabinFilter', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobDetailsNRP1ReplaceCabinFilter.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains '<status description="OK" state="0" vehicleFileVersion='
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains '<job core="false" ctid="-1" description="Replace Cabin Filter" id="080300055125" jobDifficulty="1" jobSource="MAN" jobSundryReq="false" oe="true" service="false"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetailsNRP1ReplaceCabinFilter', testSuite)
    * assert result == true

  Scenario: GetJobDetails_NRP2_Engine_Oil_and_Filter_Replacement
    * configure headers = {ldap_bac: '111148', TP_ID: 'FS_DMS'}
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobDetailsNRP2EngineOilandFilterReplacement', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobDetailsNRP2EngineOilandFilterReplacement.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains '<status description="OK" state="0" vehicleFileVersion='
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse/job[1] contains '<promotion code="NRP_P_212"'
    And assert responseTime < 4000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetailsNRP2EngineOilandFilterReplacement', testSuite)
    * assert result == true

  Scenario: GetJobDetails_NRP3_EngineOil_and_Filter_Replacement
    * configure headers = {ldap_bac: '999999', TP_ID: 'FS_DMS'}
    * def dateInsert = Java.type('utils.DateInsert')
    * def insertionResult = dateInsert.insert('GetJobDetailsNRP3EngineOilandFilterReplacement', testSuite)
    * assert insertionResult == true

    Given request read('file:target/GetJobDetailsNRP3EngineOilandFilterReplacement.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse contains '<status description="OK" state="0" vehicleFileVersion='
    And match response /Envelope/Body/getJobDetailsResponse/jobDetailsResponse/job[1] contains 'description="Engine Oil and Filter Replacement"'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetJobDetailsNRP3EngineOilandFilterReplacement', testSuite)
    * assert result == true