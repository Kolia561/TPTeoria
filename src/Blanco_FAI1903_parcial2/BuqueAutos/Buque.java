package Blanco_FAI1903_parcial2.BuqueAutos;

import java.util.concurrent.Semaphore;


public class Buque {



    private Semaphore arribaBuque = new Semaphore(10, true);
    private Semaphore esperaAutos = new Semaphore(0);
    private Semaphore lleganAutos = new Semaphore(0);


    public void subir() throws InterruptedException {

        try {

            arribaBuque.acquire();
            System.out.println(Thread.currentThread().getName()+"Subio al barco");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        esperaAutos.release();

    }

    public void crusar() {

        try {

            esperaAutos.acquire(10);
            System.out.println("--------------------------------------------------");
            System.out.println("El Buque partio");

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void bajar() {

        try {
            lleganAutos.acquire();
            System.out.println(Thread.currentThread().getName()+"Bajo del barco");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void bajarAutos() {

        System.out.println("--------------------------------------------------");
        System.out.println("El buque llego al puesto oeste");
        while (lleganAutos.hasQueuedThreads()) {

            lleganAutos.release();
        }
        
        try {

            Thread.sleep(3000);
            System.out.println("--------------------------------------------------");
            System.out.println("El buque llego al puesto este");
            arribaBuque.release(10);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
