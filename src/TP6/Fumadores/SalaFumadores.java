
package TP6.Fumadores;

import java.util.ArrayList;
import java.util.List;


public class SalaFumadores {

    private int mesa[] = new int[2];

    public SalaFumadores() {
        
        this.mesa[0] = 0;
        this.mesa[1] = 0;

    }

    public synchronized void colocar(int num) throws InterruptedException {

        while (this.lleno()) {
            System.out.println("como esta lleno espera");
            this.wait();
        }

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
        this.mesa[0] = 0;
        this.mesa[1] = 0;
        this.notifyAll();
    }

    public synchronized boolean lleno() {

        
        return this.mesa[1] != 0;
        

    }

    public synchronized boolean puedofumar(int id) {
        boolean rta = false;

        if (mesa[0] != id && mesa[1] != id && mesa[0] != 0 && mesa[1] != 0) {
            rta = true;
        }
        return rta;
    }
}
