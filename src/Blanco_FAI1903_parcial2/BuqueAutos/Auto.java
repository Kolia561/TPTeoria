package Blanco_FAI1903_parcial2.BuqueAutos;

public class Auto implements Runnable {

    private Buque buque;

    public Auto(Buque buque) {
        this.buque = buque;
    }

    @Override
    public void run() {

        try {
            buque.subir();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        buque.bajar();
    }

}
