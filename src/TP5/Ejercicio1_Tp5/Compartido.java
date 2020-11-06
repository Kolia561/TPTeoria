package TP5.Ejercicio1_Tp5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Compartido {

    private final Semaphore mutex1 = new Semaphore(1);
    private final Semaphore mutex2 = new Semaphore(1);
    private final Semaphore mutex3 = new Semaphore(1);
    private Semaphore platos;

    int vecesQComen;
    int comieron;
    int numPlatos;

    private final Map<Character, Integer> m;
    private final Iterator<Long> tiempo;

    int turno = 0;
    int caso;

    public Compartido(int platos, int caso) {

        this.comieron = 0;
        this.numPlatos=platos;

        this.platos = new Semaphore(platos);

        this.m = new HashMap<Character, Integer>();

        this.m.put('p', 1);
        this.m.put('g', 2);

        this.tiempo = new Random().longs(1000, 2000).iterator();

        this.caso = caso;
    }

    public boolean entrarAComer(Character tipo) {
        boolean rta = false;
        int num;

        if (mutex1.tryAcquire()) {

            num = m.get(Character.toLowerCase(tipo));

            if (turno == 0) {

                rta = true;
                this.turno = num;

            } else {

                if (turno == num && (comieron < vecesQComen)) {

                    rta = true;
                }

            }
        }
        return rta;
    }

    public boolean tomarPlato(Character tipo) {
        boolean rta = false;

        switch (caso) {
            case 1:

                break;

            default:

                rta = platos.tryAcquire();

                break;
        }

        return rta;
    }

    public void dejarPlato(Character tipo) throws InterruptedException {

        switch (caso) {
            case 1:

                break;

            default:

                platos.release();

                break;
        }

    }

    public void salirComedor() throws InterruptedException {

        mutex2.acquire();
        comieron++;
        if (comieron >= vecesQComen && platos.availablePermits()==) {

            turno = (turno % m.size()) + 1;

        }
        mutex2.release();

    }

}
