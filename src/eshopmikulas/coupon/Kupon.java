package eshopmikulas.coupon;

public class Kupon {
    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }

    private String code;
    private int value;

    public Kupon(String code, int value){
        this.code = code;
        this.value = value;
    }
}
