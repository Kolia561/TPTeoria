package TP5.Ejercicio1_Tp5;

import java.util.Iterator;
import java.util.Random;

public class Animal implements Runnable {

    private final Compartido comedor;
    boolean comio;
    private Iterator<Long> tiempo;
    private Character tipo;

    public Animal(Compartido comedor, Character p) {
        this.comedor = comedor;
        this.comio = false;
        this.tiempo = new Random().longs(1000, 2000).iterator();
        this.tipo = p;
    }

    @Override
    public void run() {


        if (comedor.entrarAComer(tipo)) {
            
            comedor.tomarPlato();
            comedor.dejarPlato();
            comedor.salirComedor();
        }
        
        this.pasear();




       

    }

    private void pasear() {
    }
    
    
}
