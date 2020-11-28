package zahrada.stromova.stromy.ihlicnate;

import zahrada.stromova.Strom;
import zahrada.stromova.Ihlicnate;

public class Borovica extends Strom implements Ihlicnate {
    public Borovica(int age) {
        super(age);
    }

    @Override
    public void description(){
        System.out.println("ajajajaj");
    }

}
