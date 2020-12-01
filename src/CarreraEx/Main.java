package CarreraEx;

import java.util.LinkedList;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {

        Exchanger<String> check1 = new Exchanger<>();
        Exchanger<String> check2 = new Exchanger<>();
        Exchanger<String> check3 = new Exchanger<>();
        Exchanger<String> check4 = new Exchanger<>();
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
