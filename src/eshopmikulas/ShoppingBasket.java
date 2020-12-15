package eshopmikulas;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Item> list;

    public ShoppingBasket() {
        list = new ArrayList<>();
    }

    public void addItem(Item newItem){
        if(newItem.getPrice()>=0){
            if(newItem instanceof ICountItem && ((ICountItem)newItem).getCount()>0){
                list.add(newItem);
            }
            if(newItem instanceof IWeightItem && ((IWeightItem)newItem).getWeight()>0){
                list.add(newItem);
            }
        }


        list.add(newItem);
    }
    public int getCountOfItemsInCart(){

        return list.size();
    }


    public double getTotalPrice(){
        double total = 0;
        for (Item temp:list){
            total = total + Main.formatPrice(temp.getItemPrice());
        }
        return Main.formatPrice(total);
    }
    public void printCart(){
        System.out.println("list of items in ur cart: ");
        for (Item temp: list){
            System.out.println(" -" + temp.toString() );
        }


    }

}
