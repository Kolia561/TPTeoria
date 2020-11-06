package TP5.Ejercicio3;

public class vendedorTickets implements Runnable{

    private Tren elTren;

    public vendedorTickets (Tren unTren){
        elTren = unTren;
    }

    public void run() {
        while (true) {
            try {
                
                elTren.venderTicket();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
}
