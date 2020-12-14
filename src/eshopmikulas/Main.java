package eshopmikulas;

import eshopmikulas.coupon.Kupon;
import eshopmikulas.coupon.Reade;

import java.util.List;
import java.util.Scanner;

public class Main {

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


        cart.printCart();
        System.out.println("\n Total price: " + totalPrice);
    }

    public static double formatPrice(double price){
        double result = Math.round(price*100)/100.00;
        return result;
    }


}
