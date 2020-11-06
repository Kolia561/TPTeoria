/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1_Tp5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Kolia
 */
public class Compartido2 {

    private final Semaphore mutex1 = new Semaphore(1);
    private final Semaphore mutex2 = new Semaphore(1);
    private Semaphore platos = new Semaphore(5);
    private int vecesQcomen = 5;
    private int comieron = 0;
    int turno;
    private final Map<Character, Integer> m;
    private final Iterator<Long> tiempo;

    public Compartido2() {

    

        this.m = new HashMap<Character, Integer>();

        this.m.put('p', 1);
        this.m.put('g', 2);
        this.tiempo = new Random().longs(1000, 2000).iterator();
        this.turno = 1;
    }

    public boolean entrarAcomer(Character tipo) {
        boolean rta = false;

        if (mutex1.tryAcquire()) {

            int valor = m.get(Character.toLowerCase(tipo));

            if (valor == turno && comieron <= vecesQcomen) {
                rta = true;
            }

            mutex1.release();
        }

        return rta;
    }

    boolean hayPlato() {
        boolean rta = false;

        if (mutex2.tryAcquire()) {

            if (platos > 0) {

                platos--;
                rta = true;
            }

            mutex2.release();
        }

        return rta;
    }

    synchronized void dejarComer(Character tipo) throws InterruptedException {

        System.out.println("El " + Thread.currentThread().getName() + " termino de comer");
        platos++;
        comieron++;
        //Una vez que termino de comer "avisa" que ya comio, pero solo si es su turno

        //Y solo avisa cuando es su turno para que no reste
        //de las veces que pueden comer los otros animales
        if (comieron >= vecesQcomen  && platos == 5) {    // Si se alcanso la cantidad de veces que pueden
            //comer se cambia el turno
            turno = (turno % m.size()) + 1;

            System.out.println("El " + Thread.currentThread().getName() + " dice que es el turno de ["
                    + turno + "]");

            comieron = 0;

        }

    }

}
