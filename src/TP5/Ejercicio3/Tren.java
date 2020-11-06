package TP5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Tren {

    private int cant;
    public Semaphore cantTickets = new Semaphore(0);
    public Semaphore cantPasajeros = new Semaphore(0);
    public Semaphore capacidad = new Semaphore(0);
    public Semaphore enElTren = new Semaphore(0);

    public Tren(int c) {
        cantTickets.release(c);
        cant = c;
    }

    public void venderTicket() throws InterruptedException {

        cantTickets.acquire();      // el vendedor tiene tantos tickets a la venta como capacidad el tren, al vender un ticket el semaforo tiene un permiso menos
        cantPasajeros.release();    // por lo que limita la cantidad de tickets a vender y de pasajeros
    }

    public void comprarTicket() throws InterruptedException {

        cantPasajeros.acquire();    // el pasajero intenta obtener uno de los permisos liberados por el vendedor de tickets y ocupa un lugar en la "capacidad" del tren
        capacidad.release();
        enElTren.acquire();         // mientras "esta en el tren" no puede volver a comprar mas tickets
    }

    public void arrancar() throws InterruptedException {

        capacidad.acquire(cant);    // si el tren esta a full capacidad arranca

    }

    public void llegar() {

        enElTren.release(cant);     // libera a los pasajeros que estaban "en el tren"
        cantTickets.release(cant);  // libera los tickets para que puedan ser vendidos nuevamente
    }
}
