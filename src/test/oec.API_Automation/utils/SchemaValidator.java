package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class SchemaValidator {

  public static boolean validateXml(String response, String testName, String testFolder) throws IOException {

    String responseFileName = "target/" + testName + "_" + System.currentTimeMillis() + ".xml";
    String xsdPath = "src/test/oec.API_Automation/" + testFolder +
            "/schemas/" + testName + "_Schema.xsd";

    try {
      FileOutputStream myWriter = new FileOutputStream(responseFileName);
      String str2 = new String(response.getBytes("UTF-8"));
      byte[] buffer = str2.getBytes();
      myWriter.write(buffer, 0, buffer.length);

      SchemaFactory factory =
          SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = factory.newSchema(new File(xsdPath));
      Validator validator = schema.newValidator();
      validator.validate (new StreamSource(new File(responseFileName)));
      System.out.println("Schema validation passed");
    } catch (SAXException ex) {
      System.out.println("Schema validation exception: " + ex.getMessage());
      return false;
    }
    return true;
  }
}