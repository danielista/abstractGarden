package zahrada.stromova;

public abstract class Strom {
    private int age;

    public Strom(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    public abstract void description();
    public void getFruit(){
        System.out.println("nemam ziadne ovocie");
    };


    public static void main(String[] args) {

    }


}
