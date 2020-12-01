package CarreraEx;

import java.util.concurrent.Exchanger;

public class Corredor implements Runnable {

    private Exchanger<String> lugar1;
    private Exchanger<String> lugar2;
    private String objeto = new String("testigo");

    public void run() {
        try {
            
            if (lugar2 != null) {
                if (lugar1 != null) {
                    System.out.println(Thread.currentThread().getName()+" listo para correr, espero mi turno");
                    objeto = lugar1.exchange("botella con agua");    //espera que le den el testigo
                    System.out.println(Thread.currentThread().getName()+" toma el "+objeto+" y empieza a correr");
                    Thread.sleep(2000);         //tiempo de carrera
                    //System.out.println(Thread.currentThread().getName()+" LLega a la linea de meta");
                    objeto = lugar2.exchange(objeto);    //entrega el testigo
                    System.out.println(Thread.currentThread().getName()+" Entrega el testigo y bebe de su "+objeto);
                } else{   
                    Thread.sleep(1000);  //espera a que se alisten los compañeros  (es solo para que se vea mas claro en consola)                 
                    System.out.println(Thread.currentThread().getName()+" primero, arranco ");
                    Thread.sleep(2000);         //tiempo de carrera
                    objeto = lugar2.exchange(objeto);    //el PRIMERO, despues de correr entrega el testigo.
                    System.out.println(Thread.currentThread().getName()+" Entrega el testigo y bebe de su "+objeto);
                }
            } else {                //EL ULTIMO                 
                System.out.println(Thread.currentThread().getName()+" ultimo, espero mi turno");
                objeto = lugar1.exchange("botella con agua");            //espera que le den el testigo
                System.out.println(Thread.currentThread().getName()+" toma el "+objeto+" y empieza a correr");
                Thread.sleep(2000);             //tiempo de carrera
                System.out.println(Thread.currentThread().getName()+" LLega a la linea de meta");
            }
            
        } catch (InterruptedException e) {        
            e.printStackTrace();
        }        
    }

        
    public Corredor(Exchanger<String> lugar1, Exchanger<String> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
