package TP5.Ejercicio3;

public class controlTren implements Runnable {

    private Tren elTren;

    public controlTren (Tren unTren){
        elTren = unTren;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("el tren se prepara para arrancar");
                Thread.sleep(1000);
                elTren.arrancar();
                System.out.println("el tren comenzo su viaje");
                Thread.sleep(2000);
                elTren.llegar();
                System.out.println("el tren llego a destino");
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
}
