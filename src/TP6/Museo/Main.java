package TP6.Museo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Sala museo = new Sala(50);
        List<Thread> clientes = new ArrayList<>();
        
        for (int i = 0; i < 15; i++) {

            clientes.add(new Thread(new Persona(false, museo), ("Persona "+(i+1))));
            
        }

        for (int j = 0; j < 5; j++) {
            
            clientes.add(new Thread(new Persona(true, museo), ("Jubilado "+(j+1))));

        }

        clientes.forEach(( Thread cliente ) -> {
            cliente.start();
        });
    }

}
