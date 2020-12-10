package xml.exercise;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReaderXmlFile {
    public static void main(String[] args) {
        try {

            File fXmlFile = new File("resources/futbal.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("ŠPORT: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("futbal");

            System.out.println("---------------------------------------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String FCkosice = eElement.getElementsByTagName("domaci").item(0).getTextContent();
                    String Zemplin = eElement.getElementsByTagName("hostia").item(0).getTextContent();
                    String vysledok = eElement.getElementsByTagName("vysledok").item(0).getTextContent();
                    String meno1 = eElement.getElementsByTagName("meno").item(0).getTextContent();
                    String meno2 = eElement.getElementsByTagName("meno").item(1).getTextContent();
                    String meno3 = eElement.getElementsByTagName("meno").item(2).getTextContent();
                    String cas1 = eElement.getElementsByTagName("cas").item(0).getTextContent();
                    String cas2 = eElement.getElementsByTagName("cas").item(1).getTextContent();
                    String cas3 = eElement.getElementsByTagName("cas").item(2).getTextContent();


                    System.out.println("Domáci - " + FCkosice + " ["+vysledok+"] " + Zemplin + " - Hostia");
                    System.out.println("----------------------------------------------------------");
                    System.out.println(eElement.getElementsByTagName("datum").item(0).getTextContent());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Góly: ");
                    System.out.println(FCkosice + ": " + meno1 +" ("+ cas1 +" min) ");
                    System.out.println(Zemplin + ": " + meno2 +" ("+ cas2 +" min),  " + ": " + meno3 +" ("+ cas3 +" min)");



                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
