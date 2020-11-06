package TP5.EJ4;

public class Main {

    public static void main(String[] args) {
        Torre torreAeropuerto= new Torre(10);
        Thread[] aviones = new Thread[10];

        for(int i=0; i<aviones.length; i++){
            aviones[i] = new Thread(new Avion(torreAeropuerto),"Avion"+i);
            aviones[i].start();
        }   
        
    }
    
}
