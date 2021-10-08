package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DateInsert {

  public static boolean insert(String testName, String testSuite) throws TransformerException {

    String target = "target/" + testName + ".xml";
    String xmlPath = "src/test/oec.API_Automation/" + testSuite + "/requests/" + testName + ".xml";

    LocalDateTime createdDate = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    String createdDateIso = createdDate.format(formatter);

    LocalDateTime expDate = createdDate.plusSeconds(15);
    String expiredDateIso = expDate.format(formatter);

    try {

      DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
      DocumentBuilder b = f.newDocumentBuilder();
      Document doc = b.parse(new File(xmlPath));

      Node createdNode = doc.getElementsByTagName("wsu:Created").item(0);
      createdNode.setTextContent(createdDateIso);

      Node expiredNode = doc.getElementsByTagName("wsu:Expires").item(0);
      expiredNode.setTextContent(expiredDateIso);

      Transformer tf = TransformerFactory.newInstance().newTransformer();
      DOMSource domSource = new DOMSource(doc);
      StreamResult sr = new StreamResult(new File(target));
      tf.transform(domSource, sr);

    } catch (ParserConfigurationException | SAXException | IOException | DOMException |
        TransformerFactoryConfigurationError | IllegalArgumentException | TransformerConfigurationException exp) {
      exp.printStackTrace();
      return false;
    }
    return true;
  }


}