package Blanco_FAI1903_parcial2.BuferOscilante;

import java.util.LinkedList;
import java.util.Queue;

import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    Queue<String> colaInsercion1 = new LinkedList<String>();
    Queue<String> colaExtraccion2 = new LinkedList<String>();

    private ReentrantLock lockCola1 = new ReentrantLock();
    private ReentrantLock lockCola2 = new ReentrantLock();

    public void producir(String item) throws InterruptedException {

        lockCola1.lock(); // mutex sobre la primera cola

        if (colaInsercion1.isEmpty()) { // si esta basia es porque esta en estado de insercion

            colaInsercion1.add(item); // por lo tanto agrega

            lockCola1.unlock(); // Por ultimo libera el mutex.

        } else { // Como no esta vacia, significa que ya oscilo

            lockCola1.unlock(); // Debe liberar el mutex anterior

            lockCola2.lock(); // tomar el mutex de la otra cola
            colaExtraccion2.add(item); // y agrega en la cola que ya oscilo
            lockCola2.unlock();

        }

    }

    public void consumir() throws InterruptedException {



        lockCola1.lock();
        if (!colaInsercion1.isEmpty()) { // Si la cola de insercion no esta vacia

            colaInsercion1.remove(); // Remuevo el elemento
            
            lockCola1.unlock();

        } else { // En caso de que este vacia busco en
                 // la cola de extraccion por elementos a eliminar

            lockCola1.unlock(); // libera el mutex de la cola anterior

            lockCola2.lock();
            if (!colaExtraccion2.isEmpty()) {// si la cola de extraccion tiene algo,


                colaExtraccion2.remove();   // consume.
                
            }
            lockCola2.unlock();
        }

       
    }
}
