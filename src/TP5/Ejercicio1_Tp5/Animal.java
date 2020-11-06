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
        this.tiempo = new Random().longs(500, 1000).iterator();
        this.tipo = p;
    }

    @Override
    public void run() {
        while (true) {

            if (comedor.entrarAComer(tipo)) {

                System.out.println("El " + Thread.currentThread().getName() + " entro al comedor");

                if (comedor.tomarPlato(tipo)) {

                    System.out.println("El " + Thread.currentThread().getName() + " esta comiendo");

                    try {

                        this.pasearComer();

                        comedor.dejarPlato(tipo);
                        comedor.salirComedor();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            } else {
                try {

                    this.pasearComer();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }

    }

    private void pasearComer() throws InterruptedException {

        // solo es para enmascarar el sleep
        //System.out.println("El " + Thread.currentThread().getName() + " esta paseando");
        Thread.sleep(tiempo.next());
        
    }

}
