package CarrerxRelevos;

import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {

        SynchronousQueue<Object> check1 = new SynchronousQueue<>();
        SynchronousQueue<Object> check2 = new SynchronousQueue<>();
        SynchronousQueue<Object> check3 = new SynchronousQueue<>();
        SynchronousQueue<Object> check4 = new SynchronousQueue<>();
        LinkedList<Thread> hilos = new LinkedList<>();

        hilos.add(new Thread(new Corredor(null, check1), "corredor 1"));
        hilos.add(new Thread(new Corredor(check1, check2), "corredor 2"));
        hilos.add(new Thread(new Corredor(check2, check3), "corredor 3"));
        hilos.add(new Thread(new Corredor(check3, check4), "corredor 4"));
        hilos.add(new Thread(new Corredor(check4, null), "corredor 5"));

        hilos.forEach(hilo -> {
            hilo.start();

        });

    }

}
