package Museo;

public class Persona implements Runnable {

    private boolean jubilado;
    private Sala museo;

    public Persona(boolean jub, Sala museo) {

        this.jubilado = jub;
        this.museo = museo;

    }

    @Override
    public void run() {

        while (true) {

            if (jubilado) {

                museo.entrarSalaJubilado();

                try {

                    Thread.sleep(2000);
                    museo.salirSala();

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            } else {
                museo.entrarSala();

                try {

                    Thread.sleep(1500);
                    museo.salirSala();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        }

    }

}
