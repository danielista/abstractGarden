package zahrada.stromova.stromy;

import zahrada.stromova.Strom;
import zahrada.stromova.stromy.ihlicnate.Borovica;
import zahrada.stromova.stromy.listnate.Lipa;
import zahrada.stromova.stromy.listnate.ovocne.Jablon;

public class Main {
    public static void main(String[] args) {

        System.out.println(sucet(1));


        Strom jabko = new Jablon(7);
        System.out.println(jabko.toString());

        Lipa s1 = new Lipa(18);
        Lipa s2 = new Lipa(28);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1.getAge() > s2.getAge());


    }

    private static double sucet(int n) {
            if((1/n)<0.0001) return 1/n;
            else return 1/n + sucet(1+n);

    }


}
