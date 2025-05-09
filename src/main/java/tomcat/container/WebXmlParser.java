package tomcat.container;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebXmlParser {
    public static Map<String, String> parse(String xmlPath) throws Exception {
        Map<String, String> urlMap = new HashMap<>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));

        NodeList servlets = doc.getElementsByTagName("servlet");
        Map<String, String> nameToClass = new HashMap<>();

        for (int i = 0; i < servlets.getLength(); i++) {
            Element el = (Element) servlets.item(i);
            String name = el.getElementsByTagName("servlet-name").item(0).getTextContent();
            String className = el.getElementsByTagName("servlet-class").item(0).getTextContent();
            nameToClass.put(name, className);
        }

        NodeList mappings = doc.getElementsByTagName("servlet-mapping");
        for (int i = 0; i < mappings.getLength(); i++) {
            Element el = (Element) mappings.item(i);
            String name = el.getElementsByTagName("servlet-name").item(0).getTextContent();
            String url = el.getElementsByTagName("url-pattern").item(0).getTextContent();
            urlMap.put(url, nameToClass.get(name));
        }
        return urlMap;
    }
}
