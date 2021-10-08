package GMMP.gmAPIObjectRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import utilsBrowser.XmlUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class APIPage {
    private static final Log logger = LogFactory.getLog(APIPage.class);

    XmlUtils xmlUtils = new XmlUtils();

    public Response postMethodAPI(String dealerID, String url, String path) {
        RestAssured.baseURI = url;
        Response response;
        File requestBody = new File(path);
        response = RestAssured.given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .header("ldap_bac", dealerID)
                .body(requestBody)
                .when()
                .post();
        return response;
    }

    public int getPostMethodStatusCode(Response response) {
        return response.getStatusCode();
    }

    public String getResponsePartPrice(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.partsList.part.unitPriceExcl");
    }

    public String getResponseSingleLabourPrice(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.labours.labour.labourRateExcl");
    }

    public String getResponseMMRuleTotalPrice(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.promotion.@priceIncl");
    }

    public String getResponseMMRuleJobDescription(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.promotion.@code");
    }

    public String getResponsePartPriceForDMS(Response response) {
        return xmlUtils.getValueFromXmlResponseDMS(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.partsList.part[1]");
    }

    public String getResponseStatusDescription(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.status.@description");
    }

    public String getResponseStatusState(Response response) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.status.@state");
    }

    public String getResponseStatusDescriptionByElement(Response response, String element) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body." + element + ".status.@description");
    }

    public String getResponseStatusStateByElement(Response response, String element) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body." + element + ".status.@state");
    }

    private String getContentType(Response response) {
        return response.getContentType();
    }

    public String getSOAPFaultStatus(Response response) {
        String faultStatus = null;
        if (response.getBody().asString().contains("faultcode")) {
            faultStatus = "INVALID";
        } else {
            faultStatus = "VALID";
        }
        return faultStatus;
    }

    public String getSchemaCompliance(Response response) {
        String status = null;
        if (getContentType(response).contains("text/xml")) {
            status = "VALID";
            System.out.println("Valid----" + status);
        } else {
            status = "INVALID";
            System.out.println("invalid----" + status);
        }
        return status;
    }

    public String getSOAPResponse(Response response) {
        String statusCode = null;

        if (String.valueOf(response.getStatusCode()).equals("200")) {
            statusCode = "VALID";
            System.out.println("Valid----" + statusCode);
        } else {
            statusCode = "INVALID";
            System.out.println("invalid----" + statusCode);
        }
        return statusCode;
    }

    public String getBodyMsgContains(Response response) {
        String failedMSG = null;
        String msg = "FAILED -> Missing Token [status description=\"OK\" state=\"0\"]";
        if (response.getBody().asString().contains(msg)) {
            failedMSG = "INVALID";
        } else {
            failedMSG = "VALID";
        }
        return failedMSG;
    }

    public String getBodyMsgContains1(Response response) {
        String failedMSG = null;
        String msg = "FAILED -> Missing Token [<job core=]";
        if (response.getBody().asString().contains(msg)) {
            failedMSG = "INVALID";
        } else {
            failedMSG = "VALID";
        }
        return failedMSG;
    }

    public boolean getSOAPFault(Response response, String fault) {
        boolean value;

        if (response.getBody().asString().contains(fault)) {
            value = true;
        } else {
            value = false;
        }
        return value;
    }

    public boolean getResponseTime(Response response, String duration) {

        long time = response.getTimeIn(TimeUnit.MILLISECONDS);
        int responseDuration = Integer.parseInt(duration);
        logger.info("Response time : " + time);
        logger.info("Expected Response time : " + duration);
        boolean value;
        if (time < responseDuration) {
            value = true;
        } else {
            value = false;
        }
        return value;
    }

    public String getResponseStatusDescription(Response response, String elementPath) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body." + elementPath + ".status.@description");
    }

    public String getResponsePromoTypeFlag(Response response, int index) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsByOlbResponse.jobDetailsByOlbResponse.job.promotion[" + index + "]"+".@promoType");
    }

    public String getResponseDescriptionLinkedJobs(Response response, String element) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job."+element+".job.@description");
    }

    public String getResponsePromotioncode(Response response, String element) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job."+element+".@code");
    }

    public String getResponsePromotionPrice(Response response, String element) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job."+element+".@priceFixedAt");
    }

    public String getResponseLabours(Response response, String tagName, String attributeName) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job."+tagName+".@"+attributeName);
    }

    public String getAttributeLabour(Response response, String tagName, String attributeName) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.labours."+tagName+"."+attributeName);
    }

    public String getJobAttribute(Response response, String tagName, String attributeName) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse."+tagName+".@"+attributeName);
    }

    public String getPartsListAttribute(Response response, String tagName, String attributeName) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job.partsList."+tagName+"."+attributeName);
    }

    public String getChildValue(Response response, String tagName) {
        return xmlUtils.getValueFromXmlResponse(response, "soap:Envelope.soap:Body.getJobDetailsResponse.jobDetailsResponse.job."+tagName);
    }
}
