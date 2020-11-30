package Blanco_FAI1903_parcial2.BuferOscilante;

import java.util.Iterator;
import java.util.Random;

public class Escritor implements Runnable {

    private Buffer buffer;
    private Iterator<Long> tiempo;

    public Escritor(Buffer buffer) {
        this.buffer = buffer;
        this.tiempo = new Random().longs(1000, 2000).iterator();
    }

    @Override
    public void run() {

        while (true) {

            try {
                
                buffer.producir("item");
                Thread.sleep(this.tiempo.next());

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
            
        }

    }


    
}
