package TP5.EJ4;

import java.util.Random;

public class Avion implements Runnable {

    private Torre torreControl;

    public Avion(Torre _torre) {
        this.torreControl = _torre;
    }

    @Override
    public void run() {
        try {

            while(true) {

                // el avion solicita aterrizar
                System.out.println("El avion " + Thread.currentThread().getName() + " solicita permiso para aterrizar en la pista");
                
                this.torreControl.solicitarAterrizaje();
                System.out.println("El avion " + Thread.currentThread().getName() + " esta en la cola de prioridades de la pista para aterrizar");
                
                this.torreControl.adquirirPista();
                System.out.println("El avion " + Thread.currentThread().getName() + " adquiere la pista para aterrizar");
                
                Thread.sleep((new Random().nextInt(1000)) + 1000); // tiempo para maniobra de aterrizaje
                
                // el avion aterriza y deja la pista                
                this.torreControl.terminarUsoPistaAterrizaje();
                System.out.println("El avion " + Thread.currentThread().getName() + " aterrizo exitosamente -------------------");
                
                // el avion espera en el aeropuerto
                Thread.sleep((new Random().nextInt(3000)) + 1000);

                // el avion solicita despegar
                System.out.println("El avion " + Thread.currentThread().getName() + " solicita permiso para despegar en la pista");
                this.torreControl.solicitarDespegue();
                
                this.torreControl.adquirirPista();
                
                // el avion despega exitosamente
                this.torreControl.despegueExitoso();
                System.out.println("El avion " + Thread.currentThread().getName() + " despego exitosamente --------");
                
                // el avion hace su vuelo
                Thread.sleep((new Random().nextInt(4000)) + 1000);

            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}

