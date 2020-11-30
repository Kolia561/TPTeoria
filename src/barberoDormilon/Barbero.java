package barberoDormilon;

public class Barbero implements Runnable {

    private Sala barberia;

    public Barbero(Sala barb) {

        this.barberia = barb;
    }

    @Override
    public void run() {

        barberia.cortar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        barberia.cobrar();
        

    }
    
}
