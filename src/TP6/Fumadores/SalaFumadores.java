
package TP6.Fumadores;

import java.util.ArrayList;
import java.util.List;


public class SalaFumadores {

    private int mesa[] = new int[2];

    public SalaFumadores() {
        
        this.mesa[0] = 0; // Hay dos mesas en donde se colocan los materiales
        this.mesa[1] = 0; // y donde los fumadores buscaran lo que neseciten

    }

    public synchronized void colocar(int num) throws InterruptedException {

        while (this.lleno()) {
            System.out.println("como esta lleno espera");
            this.wait();
        }

        /**Lo que se coloque en las mesas lleva la misma nomenclatura
         * que el identifcador de los fumadores
         * Como son tres fumadores y tres materias se cuenta del 1 al 3
         * y se colocan en dos mesas por lo tanto hay tres posibilidades
         * sin repeticion e ignorando el orden
         **/
        System.out.println(this.mesa[0]+this.mesa[1]);
        switch (num) {
            case 1:
                this.mesa[0] = 2;       
                this.mesa[1] = 3;
                break;
            case 2:
                this.mesa[0] = 1;
                this.mesa[1] = 3;
                break;
            case 3:
                this.mesa[0] = 1;
                this.mesa[1] = 2;
                break;
                default:
                break;
        }

        this.notifyAll();
    }

    public synchronized void entrafumar(int id) throws InterruptedException {

        while (!this.puedofumar(id)) {
            System.out.println("como no puede fumar espera.... fumador "+id);
            this.wait();
        }

       

    }

    public synchronized void terminafumar(int id) {
        System.out.println("Termino de fumar fumador "+id);
        //cuando termina de fumar vacia las mesas
        this.mesa[0] = 0;
        this.mesa[1] = 0;
        this.notifyAll();
    }

    public synchronized boolean lleno() {

        
        return this.mesa[1] != 0;
        

    }

    public synchronized boolean puedofumar(int id) {
        boolean rta = false;

        //para saber si puede fumar verifica que lo que esta en la mesa es algo distinto 
        // ya posee y ademas que no esten vacias
        if (mesa[0] != id && mesa[1] != id && mesa[0] != 0 && mesa[1] != 0) {
            rta = true;
        }
        return rta;
    }
}
