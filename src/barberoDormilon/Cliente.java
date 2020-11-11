package barberoDormilon;

public class Cliente implements Runnable {

    private Sala barberia;

    public Cliente(Sala barb) {

        this.barberia = barb;

    }

    @Override
    public void run() {
        
        barberia.solicitarCorte();
        barberia.pagar();

    }

}
