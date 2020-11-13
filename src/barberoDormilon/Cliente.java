package barberoDormilon;

public class Cliente implements Runnable {

    private Sala barberia;

    public Cliente(Sala barb) {

        this.barberia = barb;

    }

    @Override
    public void run() {

        if (barberia.entrarSala()) {

            try {
                barberia.solicitarCorte();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            barberia.pagar();

        }

    }

}
