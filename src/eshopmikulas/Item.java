package eshopmikulas;

public abstract class Item{

    private String name;
    private Double price;

    public Item(double price, String name){
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public abstract double getItemPrice();//cenu za celu položku vypočita trieda ktra bude triediť lebo tato ITEM to nevie

}
