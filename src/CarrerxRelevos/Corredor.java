package CarrerxRelevos;

import java.util.concurrent.SynchronousQueue;

public class Corredor implements Runnable {

    private SynchronousQueue<Object> lugar1;
    private SynchronousQueue<Object> lugar2;
    private Object testigo;

    @Override
    public void run() {

        if (lugar1 != null) {

            this.tomar();

            try {
                Thread.sleep((long) Math.random());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.entregar(testigo);

        } else {

            try {
                Thread.sleep((long) Math.random());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.entregar("testigo");

        }

    }

    private void tomar() {

        while (testigo == null) {

            this.testigo = this.lugar1.poll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    private void entregar(Object testigo2) {

        if (this.lugar2 != null) {

            try {
                System.out.println(Thread.currentThread().getName() + " entrego la posta");
                this.lugar2.put(testigo2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {

            System.out.println(Thread.currentThread().getName() + " llego a la meta");
        }

    }

    public Corredor(SynchronousQueue<Object> lugar1, SynchronousQueue<Object> lugar2) {
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
    }

}
