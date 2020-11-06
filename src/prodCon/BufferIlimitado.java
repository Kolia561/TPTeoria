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
        System.out.println("Se produjo un item, hay: "+cola.size());
        sem.release();
    }

    public boolean consumir() throws InterruptedException {
        boolean flag = false;
        sem.acquire();
        if (cola.size() > 0) {
            cola.remove();
            System.out.println("Se consumio un item, hay: "+cola.size());
            flag = true;
        }else {
            System.out.println("No se puede consumir item, la cola esta vacia");
        }
        sem.release();
        return flag;    
    }
}