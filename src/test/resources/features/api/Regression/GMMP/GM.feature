@API
Feature: GMMP Regression API

  Scenario: GetGenericParts2

    When send "GMMP/GetGenericParts2GMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getGenericParts2Response.genericPartsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobAddOns

    When send "GMMP/GetJobAddOnsGMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobAddOnsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario:GetJobDetails

    When send "GMMP/GetJobDetailsGMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsResponse.jobDetailsResponse' response description as 'OK'
    And assert responseTime < '3000' or '135000'


  Scenario: GetJobDifficulties

    When send "GMMP/GetJobDifficulties" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDifficultiesResponse.jobDifficultiesResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobs

    When send "GMMP/GetJobsGMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetVehicleInfo

    When send "GMMP/GetVehicleInfoGMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getVehicleInfoResponse.vehicleInfoResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetVehicleId

    When send "GMMP/GetVehicleId" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getVehicleIdResponse.vehicleIdResponse' response description as 'OK'
    And assert responseTime < '3000' or '11000'

  Scenario: GetCusType

    When send "GMMP/GetCusTypeGMMP" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getCusTypeResponse.cusTypeResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetShell

    When send "GMMP/GetShell" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getShellResponse.shellResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetVisitJobs

    When send "GMMP/GetVisitJobs" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getVisitJobsResponse.visitJobsResponse' response description as 'OK'
    And assert responseTime < '4000' or '26000'

  Scenario: GetQuoteSettings

    When send "GMMP/GetQuoteSettings" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getQuoteSettingsResponse.quoteSettingsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'