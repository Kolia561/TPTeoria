
package TP6.Fumadores;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Agente implements Runnable {

    private SalaFumadores sala;
    private Random r;

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    public void run() {
        while (true) {
            try {
                sala.colocar(r.nextInt(3) + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
