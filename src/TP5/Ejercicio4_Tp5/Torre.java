package TP5.EJ4;

import java.util.concurrent.Semaphore;

public class Torre {

    private Semaphore aterrizajesPrioridad;
    private Semaphore pista = new Semaphore(1, true);
    private Semaphore despeguePrioridad = new Semaphore(0, true);
    private int aterrizajesPrioritarios;
    private int contadorAterrizajes; // variable para cambio de prioridad
    private int solicitudAterrizajes = 0;  // utilizo esta variable para evitar deadlock si un avion quiere despegar y no tiene prioridad

    public Torre(int _aterrizajesPrioridad) {
        aterrizajesPrioridad = new Semaphore(_aterrizajesPrioridad, true);
        aterrizajesPrioritarios = _aterrizajesPrioridad;
        contadorAterrizajes = aterrizajesPrioritarios;
    }

    public void solicitarAterrizaje() {
        try {
            aterrizajesPrioridad.acquire();
            synchronized(this) {
                solicitudAterrizajes++;
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void solicitarDespegue() {
        try {
            despeguePrioridad.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void despegueExitoso() {

        synchronized (this) {

            contadorAterrizajes = aterrizajesPrioritarios;
        }

        try {
            if(solicitudAterrizajes > 0) {
                despeguePrioridad.acquire();
            }            
            pista.release();
            aterrizajesPrioridad.release(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
    }

    public void adquirirPista() {
        // solicitar permiso de pista
        try {
            pista.acquire();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void terminarUsoPistaAterrizaje() {

        synchronized(this) {
            
            contadorAterrizajes--;
            solicitudAterrizajes--;

            if(contadorAterrizajes == 0 || solicitudAterrizajes == 0) {
                despeguePrioridad.release(); // si ya llegue al limite prioritario de aterrizajes o no tengo solicitudes de aterrizajes
            }
        }
        pista.release();
    }
}