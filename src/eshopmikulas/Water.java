package eshopmikulas;

public class Water extends Item implements ICountItem{
    private int count;
    public Water(double price, String name, int count) {
        super(price, name);
        this.count=count;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public double getItemPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "WOter: "+ getName() + " , price per KG: "+getItemPrice() + Main.formatPrice(getItemPrice());

    }

}
