package Museo;

public class Termostato implements Runnable {

    private Sala museo;

    @Override
    public void run() {

        while (true) {

            museo.notificarTemperatura();
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
    
}
