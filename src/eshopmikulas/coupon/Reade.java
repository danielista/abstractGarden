package eshopmikulas.coupon;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reade {
    private static String fileName = "resources/coupon";

    public static List<Kupon> getListOfCouponsFromFile(){
        List<Kupon> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] array = data.split(" ");
                Kupon newCoupon = new Kupon(array[0],Integer.parseInt(array[1]));
                list.add(newCoupon);
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static void updateKupon(List<Kupon> list){
      try{
          File file = new File(fileName);
          FileWriter fw = new FileWriter(fileName);
          for(Kupon temp: list){
              fw.write(temp.getCode()+ " " + temp.getValue()+ "\n");
          }
          fw.flush();
          fw.close();



      }catch(Exception e){
          e.printStackTrace();
      }

    }
}
