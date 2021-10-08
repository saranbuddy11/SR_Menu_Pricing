@Regression
Feature: GM MenuPricing Maintain Estimates Test

  @TCNo(numbers=36321)
  @Search
  Scenario: Maintain Estimates - Search Estimate Test
    When Go to Maintain Estimates tab
    And Select various Statuses from the drop down list and Search.
    Then Estimates with the correct status are returned.
    When Search for estimates using VIN '1G1ZA5ST1HF190045'.
    Then All estimates with the VIN '1G1ZA5ST1HF190045' are returned.
    When Search for a estimate with partial VIN '1G1'.
    Then All estimates with VIN’s matching the partial criteria '1G1' are returned.
    When Search for estimates using Lic No 'KGR8E08' and Date '10/21/2020'.
    Then All estimates with the Lic Nos 'KGR8E08' are returned.
    When Search for a estimate with partial Lic No 'KGR'.
    Then All estimates with Lic Nos 'KGR' matching the partial criteria are returned.
    When Search for estimates using Customer 'Joe Doe'.
    Then All estimates with the Customer 'Joe Doe' are returned.
    When Search for a estimate with partial Customer 'Joe'.
    Then All estimates with Customers 'Joe' matching the partial criteria are returned.
    When Search for estimates using an Address 'Krakow'.
    And Search for a estimate with partial Address 'Kra'.
    And Search for estimates using a Zipcode '1234'
    And Search for a estimate with partial Zipcode '1'
    And Enter a specific estimate number '3' and search.
    Then The estimate number '3' is returned.
    When Enter a Date from and a Date To '11/11/2020' in the specified format and search.
    Then All estimates saved within the two dates '11/11/2020' are returned.
    When Enter a From date '11/12/2020' that is ahead of the To date '11/11/2020'. Click search.
    Then Error message appears 'The date range is invalid'.
    When Perform a search that returns multiple estimates. Click on the column headers to sort the estimates i.e. Status.
    Then Estimates are sorted as expected.
    When Find a estimate and double click on it.
    Then Estimate is opened.
    When Find a estimate and single click on it to select then click on the Continue button.
    Then Estimate is opened.
    Then Close the browser
