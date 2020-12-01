package CarrerxRelevos;

import java.util.concurrent.SynchronousQueue;

public class Corredor implements Runnable {

    private SynchronousQueue<Object> lugar1;
    private SynchronousQueue<Object> lugar2;
    private Object testigo;

    @Override
    public void run() {

        testigo = lugar1.poll();
        
        try {
            Thread.sleep((long) Math.random());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        lugar2.add(testigo);

    }

    public Corredor(SynchronousQueue<Object> lugar1, SynchronousQueue<Object> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
