package CarreraSynchC;

import java.util.concurrent.SynchronousQueue;

public class Corredor implements Runnable {

    private SynchronousQueue<String> lugar1;
    private SynchronousQueue<String> lugar2;
    private String testigo = new String("testigo");

    @Override
 /*   public void run() {
        try {
            if (lugar2 == null) {
                System.out.println(Thread.currentThread().getName()+" ultimo");
                lugar1.put(testigo);
            } else if (lugar1 == null) {
                System.out.println(Thread.currentThread().getName()+" primero");
                testigo = lugar2.poll();
            } else {
                System.out.println(Thread.currentThread().getName()+" entre");
                testigo = lugar2.poll();
                lugar1.put(testigo);
                            
                          
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {        
            e.printStackTrace();
    }
        
        System.out.println(Thread.currentThread().getName()+" sali");
   } */

    public void run() {
        try {
            if (lugar2 != null) {
                if (lugar1 != null) {
                    System.out.println(Thread.currentThread().getName()+" entre, tomo");                    
                    lugar1.put(testigo);
                    Thread.sleep(2000);
                    testigo = lugar2.poll();    //los del medio
                } else{
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" primero, arranco ");
                    testigo = lugar2.poll();    //el primero
                }
            } else {                               
                System.out.println(Thread.currentThread().getName()+" ultimo, espero");
                lugar1.put(testigo);            //el ultimo
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {        
            e.printStackTrace();
    }
        
        System.out.println(Thread.currentThread().getName()+" sali");
    }

        
    public Corredor(SynchronousQueue<String> lugar1, SynchronousQueue<String> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
