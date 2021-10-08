@API
Feature: JLRMP Regression API

  Scenario: GetGenericParts

    When send "JLR/GetGenericParts" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getGenericPartsResponse.genericPartsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobAddOns

    When send "JLR/GetJobAddOns" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobAddOnsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario:GetJobDetails_JobConfigRule

    When send "JLR/GetJobDetails_JobConfigRule" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsResponse.jobDetailsResponse' response description as 'OK'
    And assert responseTime < '3000' or '11000'

  Scenario:GetJobDetails_standard

    When send "JLR/GetJobDetails_standard" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsResponse.jobDetailsResponse' response description as 'OK'
    And assert responseTime < '4000' or '11000'

  Scenario: GetJobDifficulties

    When send "JLR/GetJobDifficulties" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDifficultiesResponse.jobDifficultiesResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'


  Scenario: GetJobs_JobIDFiltered

    When send "JLR/GetJobs_JobIDFiltered" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobs_AllJobs

    When send "JLR/GetJobs_AllJobs" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetVehicleInfo

    When send "JLR/GetVehicleInfo" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getVehicleInfoResponse.vehicleInfoResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetVehicleFile

    When send "JLR/GetVehicleFile" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getVehicleFileResponse.vehicleFileResponse' response description as 'OK'
    And assert responseTime < '3000' or '5000'

  Scenario: GetJobs_PartFiltered

    When send "JLR/GetJobs_PartFiltered" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobs_MFCFiltered

    When send "JLR/GetJobs_MFCFiltered" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobs_MFCFiltered

    When send "JLR/GetJobs_LabourFiltered" request
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsResponse.jobsResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobDetailsByEvhc

    When send "JLR/GetJobDetailsByEvhcUAT" request 2
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsByEvhcResponse.jobDetailsByEvhcResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobsByEvhcVIN

    When send "JLR/GetJobsByEvhcVINUAT" request 2
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsByEvhcResponse.jobsByEvhcResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobsByEvhcFilteredByID

    When send "JLR/GetJobsByEvhcFilteredByIDUAT" request 2
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsByEvhcResponse.jobsByEvhcResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobDetailsByOlb

    When send "JLR/GetJobDetailsByOlbUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsByOlbResponse.jobDetailsByOlbResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobsByVINOlb

    When send "JLR/GetJobsByOlbVINUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsByOlbResponse.jobsByOlbResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobsByOlbManualMatch

    When send "JLR/GetJobsByOlbManualMatchUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsByOlbResponse.jobsByOlbResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobsByOlbFilteredByID

    When send "JLR/GetJobsByOlbFilteredByIDUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobsByOlbResponse.jobsByOlbResponse' response description as 'OK'
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobDetailsByOlbSingle

    When send "JLR/NSC/GetJobDetailsByOlbSingleUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsByOlbResponse.jobDetailsByOlbResponse' response description as 'OK'
    And Verify the requested job response Promo type as 'BAU' for 0
    And assert responseTime < '3000' or '4000'

  Scenario: GetJobDetailsByOlbMultiple

    When send "JLR/NSC/GetJobDetailsByOlbMultipleUAT" request 1
    Then Verify the GetGenericParts2 response Status code as 200
    And match response Envelope not contains 'faultcode'
    And Verify the 'getJobDetailsByOlbResponse.jobDetailsByOlbResponse' response description as 'OK'
    And Verify the requested job response Promo type as 'BAU'
    And assert responseTime < '10000' or '12000'