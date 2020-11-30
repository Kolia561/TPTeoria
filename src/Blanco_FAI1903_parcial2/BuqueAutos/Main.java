package Blanco_FAI1903_parcial2.BuqueAutos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Buque buque = new Buque();
        Testigo chofer = new Testigo(buque);
        List<Thread> autos = new ArrayList<>();

        autos.add(new Thread(chofer, "Chofer"));

        for (int j = 0; j < 60; j++) {

            autos.add(new Thread(new Auto(buque), "Auto ["+(j+1)+"]"));
        
    }




        autos.forEach((Thread auto) -> {
            auto.start();
        });


    }

}
