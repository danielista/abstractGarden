package eshopmikulas;

public class Apple extends Item implements ICountItem, IWeightItem{
    private double weight;
    private int count;

    public Apple (double price, String name, double weight){
        super(price, name); //posleme konštruktoru Item toto
        this.weight=weight;
    }
    public Apple (double price, String name, int count){
        super(price, name); //posleme konštruktoru Item toto
        this.count=count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getItemPrice() {
        return weight*getPrice();
    }


}
