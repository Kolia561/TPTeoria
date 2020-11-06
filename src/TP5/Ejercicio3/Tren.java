package TP5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Tren {

    private int cant;
    public Semaphore cantTickets = new Semaphore(0);
    public Semaphore cantPasajeros = new Semaphore(0);
    public Semaphore capacidad = new Semaphore(0);
    public Semaphore enRecorrido = new Semaphore(0);

    public Tren(int c) {
        cantTickets.release(c);
        cant = c;
    }

    public void venderTicket() throws InterruptedException {

        cantTickets.acquire();
        cantPasajeros.release();
    }

    public void comprarTicket() throws InterruptedException {

        cantPasajeros.acquire();
        capacidad.release();
        enRecorrido.acquire();
    }

    public void arrancar() throws InterruptedException {

        capacidad.acquire(cant);

    }

    public void llegar() {

        enRecorrido.release(cant);
        cantTickets.release(cant);
    }
}
