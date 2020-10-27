package prodCon;

import java.util.*;
import java.util.concurrent.Semaphore;

public class BufferIlimitado {
    Queue<String> cola = new LinkedList<String>();
    private Semaphore sem = new Semaphore(1);
    public Semaphore productor = new Semaphore(1);
    public Semaphore consumidor = new Semaphore(0);

    public void producir(String item) throws InterruptedException {
        sem.acquire();
        cola.add(item);
        System.out.println("se produjo un item, hay: "+cola.size());
        sem.release();
    }

    public void consumir() throws InterruptedException {
        sem.acquire();
        if (cola.size() > 0) {
            cola.remove();
            System.out.println("se consumio un item, hay: "+cola.size());
        }else {
            System.out.println("no se puede remover item, hay: "+cola.size());
        }
        sem.release();
    }
}