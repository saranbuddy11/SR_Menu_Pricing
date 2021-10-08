package GM.gmStepDefinitions.DataValidation;

import io.cucumber.java.en.When;
import stepDefinitions.runner.AbstractAPITest;

import java.util.Arrays;
import java.util.List;

public class DataValidationTest extends AbstractAPITest {

    @When("Send requests for {string} responses from SOAP UI should be returned and assertions statuses and request status should be stored to OUTPUT file")
    public void send_requests_for_responses_from_SOAP_UI_should_be_returned_and_assertions_statuses_and_request_status_should_be_stored_to_OUTPUT_file(String sheetName) {

        try {
            String inputSheetName = null;
            String outputSheetName = null;
            String countryCode = null;
            List<String> env = Arrays.asList(configuration.getDataUSDealerId(), configuration.getDataMXDealerId());
            for (int i = 0; i <= env.size(); i++) {
                if (env.get(i).contains(configuration.getUSCountryCode())) {
                    inputSheetName = "GM_DataValidations_" + configuration.getUSCountryCode() + "_20201130";
                    countryCode = configuration.getUSCountryCode();
                    outputSheetName = sheetName + countryCode;
                } else if (env.get(i).contains(configuration.getMXCountryCode())) {
                    inputSheetName = "GM_DataValidations_" + configuration.getMXCountryCode() + "_20201130";
                    countryCode = configuration.getMXCountryCode();
                    outputSheetName = sheetName + countryCode;
                }
                for (int j = 1; j <= excel.lastRowNumber(configuration.getInputExcelFileName(), inputSheetName); j++) {
                    String vin = excel.readExcel(configuration.getInputExcelFileName(), inputSheetName, j, 0).trim();
                    String jobId = excel.readExcel(configuration.getInputExcelFileName(), inputSheetName, j, 1).trim();
                    xmlUtils.setValuesInXmlFileForDataValidation(getRequestBodyDataValidationPath(sheetName.replace("_", "")), jobId, vin, countryCode);
                    response = apiPage.postMethodAPI(env.get(i), configuration.getAPIUrl(), getRequestBodyDataValidationPath(sheetName.replace("_", "")));
                    String statusCode = String.valueOf(apiPage.getPostMethodStatusCode(response));
                    String description = "description=" + apiPage.getResponseStatusDescription(response) + "   " + "state=" + apiPage.getResponseStatusState(response);
                    String contentType = apiPage.getSchemaCompliance(response);
                    String faultStatus = apiPage.getSOAPFaultStatus(response);
                    String SOAPResponseStatus = apiPage.getSOAPResponse(response);
                    String contains = apiPage.getBodyMsgContains(response);
                    String contains1 = apiPage.getBodyMsgContains1(response);
                    List<String> values = Arrays.asList(vin, jobId, getEnvironmentType(), countryCode, excel.timeStamp(), statusCode, description, SOAPResponseStatus, contentType, faultStatus, contains, contains1);
                    excel.writeExcel(configuration.getOutputExcelFileName(), outputSheetName, values);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("Send requests for {string} responses from SOAP UI should be returned and assertions statuses and request status for {string} should be stored to OUTPUT file without JobID")
    public void send_requests_for_responses_from_SOAP_UI_should_be_returned_and_assertions_statuses_and_request_status_for_should_be_stored_to_OUTPUT_file_without_JobID(String sheetName, String element) {
        try {
            String inputSheetName = null;
            String outputSheetName = null;
            String countryCode = null;
            List<String> env = Arrays.asList(configuration.getDataUSDealerId(), configuration.getDataMXDealerId());
            for (int i = 0; i <= env.size(); i++) {
                if (env.get(i).contains(configuration.getUSCountryCode())) {
                    inputSheetName = "GM_DataValidations_" + configuration.getUSCountryCode() + "_20201130";
                    countryCode = configuration.getUSCountryCode();
                    outputSheetName = sheetName + countryCode;
                } else if (env.get(i).contains(configuration.getMXCountryCode())) {
                    inputSheetName = "GM_DataValidations_" + configuration.getMXCountryCode() + "_20201130";
                    countryCode = configuration.getMXCountryCode();
                    outputSheetName = sheetName + countryCode;
                }
                for (int j = 1; j <= excel.lastRowNumber(configuration.getInputExcelFileName(), inputSheetName); j++) {
                    String vin = excel.readExcel(configuration.getInputExcelFileName(), inputSheetName, j, 0).trim();
                    xmlUtils.setValuesInXmlFileForDataValidationWithoutJobID(getRequestBodyDataValidationPath(sheetName.replace("_", "")), vin, countryCode);
                    response = apiPage.postMethodAPI(env.get(i), configuration.getAPIUrl(), getRequestBodyDataValidationPath(sheetName.replace("_", "")));
                    String statusCode = String.valueOf(apiPage.getPostMethodStatusCode(response));
                    String description = "description=" + apiPage.getResponseStatusDescriptionByElement(response, element) + "   " + "state=" + apiPage.getResponseStatusStateByElement(response, element);
                    String contentType = apiPage.getSchemaCompliance(response);
                    String faultStatus = apiPage.getSOAPFaultStatus(response);
                    String SOAPResponseStatus = apiPage.getSOAPResponse(response);
                    String contains = apiPage.getBodyMsgContains(response);
                    String contains1 = apiPage.getBodyMsgContains1(response);
                    List<String> values = Arrays.asList(vin, getEnvironmentType(), countryCode, excel.timeStamp(), statusCode, description, SOAPResponseStatus, contentType, faultStatus, contains, contains1);
                    excel.writeExcel(configuration.getOutputExcelFileName(), outputSheetName, values);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}