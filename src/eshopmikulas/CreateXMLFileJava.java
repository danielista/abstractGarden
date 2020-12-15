package eshopmikulas;
import java.io.File;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFileJava {
    public static final String xmlFilePath = "out\\xmlDANOfile.xml";

    public static void main(String argv[]) {



        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        System.out.println(strDate);

        Date time1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String strTime = formatter.format(time1);
        System.out.println(strTime);




            try {

                DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

                Document document = documentBuilder.newDocument();

                // root element
                Element root = document.createElement("bill");
                document.appendChild(root);


                Element date2 = document.createElement("date");
                date2.appendChild(document.createTextNode(strDate));
                root.appendChild(date2);


                Element time2 = document.createElement("time");
                time2.appendChild(document.createTextNode(strTime));
                root.appendChild(time2);

                // items element
                Element items = document.createElement("items");

                root.appendChild(items);

                // set an attribute to staff element
                Attr attr = document.createAttribute("counts");
            //    attr.setValue();

                items.setAttributeNode(attr);

                //you can also use staff.setAttribute("id", "1") for this

                // firstname element
                Element firstName = document.createElement("firstname");
                firstName.appendChild(document.createTextNode("James"));
                items.appendChild(firstName);

                // lastname element
                Element lastname = document.createElement("lastname");
                lastname.appendChild(document.createTextNode("Harley"));
                items.appendChild(lastname);

                // email element
                Element email = document.createElement("email");
                email.appendChild(document.createTextNode("james@example.org"));
                items.appendChild(email);

                // department elements
                Element department = document.createElement("department");
                department.appendChild(document.createTextNode("Human Resources"));
                items.appendChild(department);

                // create the xml file
                //transform the DOM Object to an XML File
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(xmlFilePath));

                // If you use
                // StreamResult result = new StreamResult(System.out);
                // the output will be pushed to the standard output ...
                // You can use that for debugging

                transformer.transform(domSource, streamResult);

                System.out.println("Done creating XML File");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }
}
