package zahrada.stromova.stromy.listnate.ovocne;

import zahrada.stromova.Strom;

public class Jablon extends Strom {

    public Jablon(int age){
        super(age);
    }

    @Override
    public void description(){
        System.out.println("mam chutne jablka mnami");
    }

    @Override
    public void getFruit() {
        System.out.println("mam chutnučke jablcka kamarad");
    }
}
