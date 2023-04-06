package fergie.me;

import fergie.me.Data.Coordinates;
import fergie.me.Data.Movie;
import fergie.me.Data.MovieGenre;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.management.InvalidAttributeValueException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Scanner scanner;
    private String field = "<(\\w+)>(.+)</\\w+>";
    private Pattern pattern = Pattern.compile(field);
                                                                    //throws invalidAttributeValueExcep?
    public List<Movie> readFromFile(String fileName) throws IOException, InvalidAttributeValueException, ParserConfigurationException, SAXException {
        List<Movie> movies = new ArrayList<>();
        scanner = new Scanner(new File("src\\main\\java\\fergie\\me\\" + fileName));

        StringBuilder xml = new StringBuilder();
        while (scanner.hasNextLine()) {
            xml.append(scanner.nextLine());
        }


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new InputSource(xml.toString()));
        doc.getDocumentElement().normalize();


        Movie movie = new Movie();

        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the value of the ID attribute.
                String ID = node.getAttributes().getNamedItem("ID").getNodeValue();

                // Get the value of all sub-elements.
                String name = elem.getElementsByTagName("Name")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String lastname = elem.getElementsByTagName("Lastname").item(0)
                        .getChildNodes().item(0).getNodeValue();

                Integer age = Integer.parseInt(elem.getElementsByTagName("Age")
                        .item(0).getChildNodes().item(0).getNodeValue());

                Double salary = Double.parseDouble(elem.getElementsByTagName("Salary")
                        .item(0).getChildNodes().item(0).getNodeValue());

//                movies.add(new Movie(ID, name, lastname, age, salary));
            }
        }




        return movies;
    }
}
