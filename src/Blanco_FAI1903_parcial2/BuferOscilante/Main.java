package Blanco_FAI1903_parcial2.BuferOscilante;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> hilos = new ArrayList<>();

        Buffer buffer = new Buffer();

        for (int i = 0; i < 10; i++) {
            hilos.add(new Thread(new Lector(buffer), "Lector [" + (i + 1) + "]"));
        }

        for (int j = 0; j < 4; j++) {
            hilos.add(new Thread(new Escritor(buffer), "Escritor [" + (j + 1) + "]"));
        }

        hilos.forEach((Thread hilo) -> {
            hilo.start();
        });
    }

}
