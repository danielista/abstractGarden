package eshopmikulas;

import eshopmikulas.coupon.Kupon;
import eshopmikulas.coupon.Reade;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String xmlFilePath = "out\\xmlDANOfile.xml";

    public static void main(String[] args) {

        ShoppingBasket cart = new ShoppingBasket();
        Item item1 = new Apple(1.11, "golden", 3.5);
        Item item2 = new Water(0.51, "budis", 5);
        Item item3 = new Water(0.99, "orange - juice", 3);
        Item item4 = new Apple(0.69, "red apple", 1.54);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);



        double totalPrice = cart.getTotalPrice();

        System.out.println("Do you have any coupon (y/n)?");
        Scanner sc = new Scanner(System.in);
        String voucher;
        String input = sc.nextLine().toLowerCase();
        if(input.charAt(0) == 'y'){
            System.out.println("Enter code: ");
            voucher = sc.nextLine();
            List<Kupon> list = Reade.getListOfCouponsFromFile();
            totalPrice = cart.getTotalPrice();
            for(Kupon temp:list){
                if(temp.getCode().equalsIgnoreCase(voucher)){
                    System.out.println("voucher is valid");
                    totalPrice = totalPrice*(1-(double)temp.getValue()/100);
                    list.remove(temp);
                    break;
                }
            }
        }

        // počet Itemov
        int itemsNumber = cart.getCountOfItemsInCart();
       // System.out.println(itemsNumber);


        cart.printCart();
        System.out.println("\n Total price: " + totalPrice);



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

            // bill element
            Element bill = document.createElement("bill");
            document.appendChild(bill);


            Element date2 = document.createElement("date");
            date2.appendChild(document.createTextNode(strDate));
            bill.appendChild(date2);


            Element time2 = document.createElement("time");
            time2.appendChild(document.createTextNode(strTime));
            bill.appendChild(time2);

            // items element
            Element items = document.createElement("items");

            bill.appendChild(items);

            // set an attribute to staff element
            Attr attr = document.createAttribute("counts");
            attr.setValue(String.valueOf(itemsNumber));

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

            Element totalprice2 = document.createElement("totalPrice");
            totalprice2.appendChild(document.createTextNode(String.valueOf(totalPrice)));
            bill.appendChild(totalprice2);


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







    public static double formatPrice(double price){
        double result = Math.round(price*100)/100.00;
        return result;
    }


}
