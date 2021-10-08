package utilsBrowser;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class XmlUtils {
    private static final Log logger = LogFactory.getLog(XmlUtils.class);

    public String getValueFromXmlResponse(Response response, String xmlResponsePath) {
        XmlPath xmlResponseValue = new XmlPath(response.then().extract().asString()).using(xmlPathConfig().namespaceAware(false));
        return xmlResponseValue.getString(xmlResponsePath);
    }

    public String getValueFromXmlResponseDMS(Response response, String xmlResponsePath) {
        XmlPath xmlResponseValue = new XmlPath(response.then().extract().asString()).using(xmlPathConfig().namespaceAware(false));
        return xmlResponseValue.getString(xmlResponsePath);
    }

    public XmlUtils setValuesInXmlFile(String requestPath, String jobId, String vinNo) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(requestPath);
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            logger.info("Created time value is:" + sdf.format(date));

            date = DateUtils.addMinutes(date, 5);
            SimpleDateFormat expiredSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

            logger.info("Expires time value is:" + sdf.format(date));

            Node job = doc.getElementsByTagName("job").item(0);
            NamedNodeMap attr = job.getAttributes();
            Node nodeatr = attr.getNamedItem("id");
            logger.info("nodeatr value is:" + nodeatr.getTextContent());
            nodeatr.setTextContent(String.valueOf(jobId));
            logger.info("nodeatr value is:" + nodeatr.getTextContent());

            Node vinMatch = doc.getElementsByTagName("vinMatch").item(0);
            vinMatch.setTextContent(vinNo);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(requestPath);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return this;
    }

    public XmlUtils setValuesInXmlFileForDataValidation(String requestPath, String jobId, String vinNo, String countryCode) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(requestPath);
            Node root = doc.getFirstChild();
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            logger.info("Created time value is:" + sdf.format(date));

            date = DateUtils.addMinutes(date, 5);
            SimpleDateFormat expiredSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

            logger.info("Created time value is:" + expiredSDF.format(date));

            Node dealerDetails = doc.getElementsByTagName("dealerDetails").item(0);
            NamedNodeMap attr = dealerDetails.getAttributes();
            Node nodeatr = attr.getNamedItem("countryCode");
            nodeatr.setTextContent(String.valueOf(countryCode));

            Node job = doc.getElementsByTagName("job").item(0);
            NamedNodeMap attr1 = job.getAttributes();
            Node nodeatr1 = attr1.getNamedItem("id");
            nodeatr1.setTextContent(String.valueOf(jobId));

            Node vinMatch = doc.getElementsByTagName("vinMatch").item(0);
            vinMatch.setTextContent(vinNo);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(requestPath);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return this;
    }

    public XmlUtils setValuesInXmlFileForDataValidationWithoutJobID(String requestPath, String vinNo, String countryCode) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(requestPath);
            Node root = doc.getFirstChild();
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            logger.info("Created time value is:" + sdf.format(date));

            date = DateUtils.addMinutes(date, 5);
            SimpleDateFormat expiredSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

            logger.info("Created time value is:" + expiredSDF.format(date));

            Node dealerDetails = doc.getElementsByTagName("dealerDetails").item(0);
            NamedNodeMap attr = dealerDetails.getAttributes();
            Node nodeatr = attr.getNamedItem("countryCode");
            nodeatr.setTextContent(String.valueOf(countryCode));

            Node vinMatch = doc.getElementsByTagName("vinMatch").item(0);
            vinMatch.setTextContent(vinNo);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(requestPath);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getValuesInXmlFile(Response response, String tagName, int index) {
        String nodeValue = "";
        try {
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response.toString())));
            System.out.println("response--- " + response.toString());

            NodeList nodeList = document.getElementsByTagName(tagName);
            Node node = nodeList.item(index);
            nodeValue = node.getNodeValue();

            System.out.println("nodeValue" + nodeValue);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodeValue;
    }

    public XmlUtils setTimeStampInXmlFile(String requestPath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(requestPath);
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            logger.info("Created time value is:" + sdf.format(date));

            date = DateUtils.addMinutes(date, 5);
            SimpleDateFormat expiredSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            logger.info("Created time value is:" + expiredSDF.format(date));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(requestPath);
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return this;
    }
}