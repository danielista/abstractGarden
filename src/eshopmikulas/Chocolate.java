package eshopmikulas;

public class Chocolate extends Item implements ICountItem{
    private int count;
    public Chocolate(double price, String name, int count) {
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
}
