@Regression
@Data
Feature: GM MenuPricing Data Validation Test

  Scenario: GetJobDetails
    When Send requests for 'GetJobDetails_' responses from SOAP UI should be returned and assertions statuses and request status should be stored to OUTPUT file

  Scenario: GetVehicleInfo
    When Send requests for 'GetVehicleInfo_' responses from SOAP UI should be returned and assertions statuses and request status for 'getVehicleInfoResponse.vehicleInfoResponse' should be stored to OUTPUT file without JobID

  Scenario: GetJobAddOns
    When Send requests for 'GetJobAddOns_' responses from SOAP UI should be returned and assertions statuses and request status for 'getJobAddOnsResponse.jobsResponse' should be stored to OUTPUT file without JobID

  Scenario: GetJobs
    When Send requests for 'GetJobs_' responses from SOAP UI should be returned and assertions statuses and request status for 'getJobsResponse.jobsResponse' should be stored to OUTPUT file without JobID