@JLRRegression
Feature: JLR MenuPricing Historic Quote Test

  @TCNo(numbers=36255)
  @SearchQuote
  Scenario: Search Quote Test
    When Go to Historic Quote - Search Quote tab
    And Select various Statuses from the drop down list and Search.
    Then Estimates with the correct status are returned.
    When Search for estimates using VIN 'SALVA2AE2EH894156'.
    Then All estimates with the VIN 'SALVA2AE2EH894156' are returned.
    When Search for a estimate with partial VIN 'SAL'.
    Then All estimates with VIN’s matching the partial criteria 'SAL' are returned.
    When Search for estimates using Lic No 'LF14VDD' and Date '10/09/2020'.
    Then All estimates with the Lic Nos 'LF14VDD' are returned.
    When Search for a estimate with partial Lic No 'LF1'.
    Then All estimates with Lic Nos 'LF1' matching the partial criteria are returned.
    When Search for estimates using Customer 'Joe Doe'.
    Then All estimates with the Customer 'Joe Doe' are returned.
    When Search for a estimate with partial Customer 'Joe'.
    Then All estimates with Customers 'Joe' matching the partial criteria are returned.
    When Search for estimates using an Address 'Krakow'.
    And Search for a estimate with partial Address 'Kra'.
    And Search for estimates using a Zipcode '123'
    And Search for a estimate with partial Zipcode '1'
    And Enter a specific estimate number '31' and search.
    Then The estimate number '31' is returned.
    When Enter a Date from and a Date To '25/05/2021' in the specified format and search.
    Then All estimates saved within the two dates '25/05/2021' are returned.
    When Enter a From date '25/05/2021' that is ahead of the To date '24/05/2021'. Click search.
    Then Search error message appears 'The date range is invalid'.
    When Perform a search that returns multiple estimates. Click on the column headers to sort the estimates i.e. Status.
    Then Estimates are sorted as expected.
    When Find a estimate and double click on it.
    Then Quote is opened.
    When Find a estimate and single click on it to select then click on the Continue button.
    Then Quote is opened.
    When Select each Status and search '30/04/2020'
    Then Only quotes in the specified Status are returned.

  @TCNo(numbers=36256)
  @HistoricQuote
  Scenario: Historic Quote Functionality Test
    When Go to Historic Quote - Search Quote tab
    And Find a quote and open it.
    And Click on each of the quote tabs.
    Then Vehicle, Quote,Customer and Notes tab opened and display expected info.
    When Click on the New Search button.
    Then User is returned to the Historic Quotes search screen.
    When Click on the Delete button.
    Then User is prompted to confirm quote delete "Do you really want to delete the current quote?"
    When Select Cancel
    When Click on the Delete button again and click OK.
    Then User is returned to the Maintain Quote search screen and the quotes status is now Deleted.
    When Click on the Print button.
    Then Print options screen shown.
    When Detailed button is enabled.
    When Detailed$2 button is enabled.
    When Summary button is enabled.
    When Click on the <  button.
    Then User is returned to quote view
    When Open quote and click on the Copy button.
    When Click the Cancel button.
    When Click on the Continue button until the save screen appears.
    Then Original quote is left as is and a new copy is created.
      | 1 | Service Schedules Check & Inspect Carry Out Quality Check - With Road Test (During Service) | £22.50 |
      | 1 | Compressor & Drive Remove & Replace Compressor | £970.52 |
    When Click Save.
    Then Copy of quote is saved.
      | 1 | Service Schedules Check & Inspect Carry Out Quality Check - With Road Test (During Service) | £22.50 |
      | 1 | Compressor & Drive Remove & Replace Compressor | £970.52 |