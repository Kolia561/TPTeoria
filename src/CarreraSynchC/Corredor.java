package CarreraSynchC;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Corredor implements Runnable {

    private SynchronousQueue<String> lugar1;
    private SynchronousQueue<String> lugar2;
    private String testigo = new String("testigo");

    public void run() {
        try {
            
            if (lugar2 != null) {
                if (lugar1 != null) {
                    System.out.println(Thread.currentThread().getName()+" listo para correr, espero mi turno");                    
                    lugar1.put(testigo);
                    Thread.sleep(2000);         //tiempo de carrera
                    System.out.println(Thread.currentThread().getName()+" LLega a la linea de meta");
                    testigo = lugar2.poll();    //los del medio
                } else{                    
                    System.out.println(Thread.currentThread().getName()+" primero, arranco ");
                    Thread.sleep(2000);         //tiempo de carrera
                    testigo = lugar2.poll(6000, TimeUnit.MILLISECONDS);    //el primero, usa una sincronizacion con espera porque se puede dar que intente "tomar" antes de que el segundo "ponga"
                    System.out.println(Thread.currentThread().getName()+" LLega a la linea de meta");
                }
            } else {                               
                System.out.println(Thread.currentThread().getName()+" ultimo, espero mi turno");
                lugar1.put(testigo);            //el ultimo pone en su "lugar 1"
                Thread.sleep(2000);             //tiempo de carrera
                System.out.println(Thread.currentThread().getName()+" LLega a la linea de meta");
            }
            
        } catch (InterruptedException e) {        
            e.printStackTrace();
        }        
    }

        
    public Corredor(SynchronousQueue<String> lugar1, SynchronousQueue<String> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
