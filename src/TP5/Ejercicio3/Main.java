package TP5.Ejercicio3;

public class Main{
    
    public static void main(String[] args) {
    
        int canPasajeros = 8;
        Tren unTren = new Tren(canPasajeros);
        Thread[] pasajeros = new Thread[10];
        Thread vendedor = new Thread(new vendedorTickets(unTren));
        Thread tren = new Thread(new controlTren(unTren));

        tren.start();
        vendedor.start();
        for(int i=0; i<pasajeros.length; i++){
            pasajeros[i] = new Thread(new Pasajero(unTren),"Pasajero "+(i+1));
            pasajeros[i].start();
        }



    }
}