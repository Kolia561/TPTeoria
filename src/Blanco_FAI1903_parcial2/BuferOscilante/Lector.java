package Blanco_FAI1903_parcial2.BuferOscilante;

import java.util.Iterator;
import java.util.Random;

public class Lector implements Runnable {

    private Buffer buffer;
    private Iterator<Long> tiempo;

    public Lector(Buffer buffer) {
        this.buffer = buffer;
        this.tiempo = new Random().longs(1000, 2000).iterator();
    }

    @Override
    public void run() {

        while (true) {

            try {
                this.buffer.consumir();
                Thread.sleep(this.tiempo.next());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }


    
}
