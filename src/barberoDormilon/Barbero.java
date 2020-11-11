package barberoDormilon;

public class Barbero implements Runnable {

    private  Sala barberia;

    public Barbero(Sala barb){

        this.barberia = barb;
    }

    @Override
    public void run() {

        barberia.cortar();
        Thread.sleep(2000);
        barberia.cobrar();
        

    }
    
}
