package prodCon;

public class Main {
    public static void main(String[] args) {
        BufferIlimitado buff = new BufferIlimitado();
        Productor prod = new Productor(buff);
        Thread produ = new Thread(prod);
        Consumidor con = new Consumidor(buff);
        Thread consu = new Thread(con);        

        produ.start();
        consu.start();
    }
}