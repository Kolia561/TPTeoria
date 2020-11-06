/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1_Tp5;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Kolia
 */
public class Animal2 implements Runnable {

    private final Compartido2 comedor;
    boolean comio;
    private Iterator<Long> tiempo;
    private Character tipo;

    public Animal2(Compartido2 comedor, Character p) {
        this.comedor = comedor;
        this.comio = false;
        this.tiempo = new Random().longs(1000, 2000).iterator();
        this.tipo = p;
    }

    @Override
    public void run() {

        while (true) { //Este while simula el modelo de forma continua

            while (!comedor.entrarAcomer(tipo)) { // se pregunta si es el turno del anumal

                //Mientras que no sea el tiempo del animal esperara por un tiempo
                try {
                    System.out.println("El " + Thread.currentThread().getName() + " esta esperando por su turno");
                    Thread.sleep(tiempo.next());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animal2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            while (!comedor.hayPlato()) { // Una vez que sea el tiempo del animal preguntara si hay plato libre

                //Mientra que no halla plato libre esperara a que se desocupen
                try {
                    System.out.println("El " + Thread.currentThread().getName() + " esta esperando por un plato");
                    Thread.sleep(tiempo.next());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animal2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //-------------------------------------------------------------------------
            // Una vez que obtuvo su turno y plato, come
            try {
                this.comer();
                comedor.dejarComer(tipo);
                tiempo.next();

            } catch (InterruptedException ex) {
                Logger.getLogger(Animal2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void comer() throws InterruptedException {
        
        System.out.println("El " + Thread.currentThread().getName() + " esta comiendo");
        Thread.sleep(tiempo.next()); //se simula el tiempo que pasa comiendo
    }

}
