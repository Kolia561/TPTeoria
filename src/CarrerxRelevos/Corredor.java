package CarrerxRelevos;

import java.util.concurrent.SynchronousQueue;

public class Corredor implements Runnable {

    private SynchronousQueue<Object> lugar1;
    private SynchronousQueue<Object> lugar2;
    private Object testigo;

    @Override
    public void run() {

        if (lugar1 != null) {

            testigo = lugar1.poll();

            try {
                Thread.sleep((long) Math.random());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (lugar2!=null) {

                lugar2.add(testigo);
                
            } else {
                
                System.out.println(Thread.currentThread().getName()+" llego a la meta");
            }

        } else {

            try {
                Thread.sleep((long) Math.random());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (lugar2!=null) {

                lugar2.add("testigo");
                
            } else {
                
                System.out.println(Thread.currentThread().getName()+" llego a la meta");
            }
        }

    }

    public Corredor(SynchronousQueue<Object> lugar1, SynchronousQueue<Object> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
