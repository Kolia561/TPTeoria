package TP5.Ejercicio3;

public class Pasajero implements Runnable {

    private Tren elTren;

    public Pasajero (Tren unTren){
        elTren = unTren;
    }

    public void run() {
        
        while (true) {
            try {
                System.out.println("el pasajero "+Thread.currentThread().getName()+" intenta comprar un ticket");
                elTren.comprarTicket();
                System.out.println("el pasajero "+Thread.currentThread().getName()+" se baja del tren");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
}
