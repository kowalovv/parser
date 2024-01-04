package org.example.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.example.parser.data.Store;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


public class Executor {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/store.xml";
        String xsdFilePath = "src/main/resources/store.xsd";
        String jsonFilePath = "src/main/resources/store.json";

        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);
        File jsonFile = new File(jsonFilePath);

//        Parsing with DOM parser and validate
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            NodeList departmentList = document.getElementsByTagName("department");

            Node departmentNode = departmentList.item(0);
            Element departmentElement = (Element) departmentNode;
            String departmentName = departmentElement.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("Department name: " + departmentName);
            System.out.println("------------");
            System.out.println("Success: XML parsed successfully.");
            System.out.println("------------");

//            Validate
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));

            System.out.println("Success: XML is valid according to XSD.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: XML parsing or validation failed.");
        } finally {
            System.out.println("------------");
        }


//    Parse XML using JAXB
        try {
            JAXBContext context = JAXBContext.newInstance(Store.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Store store = (Store) unmarshaller.unmarshal(xmlFile);

            String firstName = store.getDepartments().get(0).getEmployees().get(1).getFirstName();
            String lastName = store.getDepartments().get(0).getEmployees().get(1).getLastName();
            System.out.println(firstName + " " + lastName);

            LocalDateTime endDate = store.getOrders().get(0).getEndDate();
            System.out.println(endDate);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("------------");
        }

//        Parse JSON using JACKSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            Store store = mapper.readValue(jsonFile, Store.class);
            String phoneNumber = store.getDepartments().get(0).getEmployees().get(0).getDetail().get(0).getPhoneNumber();
            LocalDateTime startDate = store.getOrders().get(0).getStartDate();
            System.out.println(phoneNumber + " " + startDate);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



