package eshopmikulas.service;

import eshopmikulas.Item;

public class Delivery extends Item implements IServiceInterface {

    public Delivery(double price) {
        super(price, "delivery");
    }

    @Override
    public double getItemPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "Delivery, Price: "+getPrice();
    }
}
