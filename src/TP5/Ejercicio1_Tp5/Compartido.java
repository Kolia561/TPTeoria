package TP5.Ejercicio1_Tp5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Compartido {

    private final Semaphore mutex1 = new Semaphore(1);
    private final Semaphore mutex2 = new Semaphore(1);
    private Semaphore platos;

    private final Map<Character, Integer> m;
    private final Iterator<Long> tiempo;

    int turno = 0;

    public Compartido(int platos) {

        this.platos = new Semaphore(platos);

        this.m = new HashMap<Character, Integer>();

        this.m.put('p', 1);
        this.m.put('g', 2);
        this.tiempo = new Random().longs( 1000, 2000 ).iterator();
    }

    public boolean entrarAComer( Character tipo)  {
        boolean rta = false;
        int num;

        if ( mutex1.tryAcquire() ) {

            num = m.get( Character.toLowerCase( tipo ) );

            if ( turno == 0 ) {

                rta = true;
                this.turno = num;

            } else {

                if ( turno == num ) {

                    rta = true;
                }

            }
        }
        return rta;
    }

    public void tomarPlato() {

    
    }

    public void dejarPlato() {
    }

    public void salirComedor() {
    }

}
