package prodCon;

public class Consumidor implements Runnable {
    BufferIlimitado buff;

    public Consumidor(BufferIlimitado unBuffer) {
        buff = unBuffer;
    }

    @Override
    public void run() {
        try {
            buff.consumidor.acquire();
            while (true) {
                if (Math.floor(Math.random()*3 + 1) == 1) {

                    buff.productor.release();
                    buff.consumidor.acquire();
                }
                Thread.sleep(300);
                buff.consumir();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
