package test.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utils {

	public static String getValueByKey(String key) {
		String value = null;
		try {
			File fXmlFile = new File("src/test/config/config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("config");
			Element element = (Element) nList.item(0);
			value = element.getElementsByTagName(key).item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
