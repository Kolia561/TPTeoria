package barberoDormilon;

public class Sala {

    private boolean cortando;
    private boolean termino;
    private int lugareSala;

    public synchronized boolean entrarSala() {
        return cortando;

    }

    public synchronized void solicitarCorte() throws InterruptedException {

    }

    public void cortar() {
    }

    public void cobrar() {
    }

    public void pagar() {
    }

}
