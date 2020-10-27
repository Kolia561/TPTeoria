package prodCon;

public class Productor implements Runnable {
    BufferIlimitado buff;

    public Productor(BufferIlimitado unBuffer) {
        buff = unBuffer;
    }

    @Override
    public void run() {
        try {
        buff.productor.acquire();
        while(true){
            if(Math.floor(Math.random()*3 + 1) == 1){
                buff.consumidor.release();
                buff.productor.acquire();
            }
            Thread.sleep(300);
            buff.producir("item");
            }
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }

    }
    
}