package Museo;

public class Sala {

    private int cupo;
    private int temperatura;
    private int jubilados;
    private int dentro;

    public Sala(int capacidad) {

        this.cupo = capacidad;
        this.temperatura = 25;
        this.dentro = 0;
        this.jubilados = 0;

    }

    public synchronized boolean entrarSala() throws InterruptedException {

        boolean rta = false;

        while (jubilados > 0) {
            this.wait();
        }

        if (dentro <= cupo) {

            dentro++;
            rta=true;

        }

        return rta;

    }

    public synchronized boolean entrarSalaJubilado() {

        boolean rta=false;

        jubilados++;

        if(dentro>=cupo) {

            rta=true;
            
        } 
        return rta;

    }

    public void salirSala() {

    }

    public void notificarTemperatura() {

    }
}
