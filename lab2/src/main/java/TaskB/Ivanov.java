package TaskB;

import java.util.Queue;

public class Ivanov implements Runnable {
    private Thread thread;
    private Stock stock;
    private volatile Queue buffer;
    private Petrenko petrenko;

    Ivanov(Stock stock, Queue<Integer> buffer, Petrenko petrenko) {
        this.stock = stock;
        this.buffer = buffer;
        this.petrenko = petrenko;
        thread = new Thread(this, "Ivanov");
        thread.start();
    }

    public void run() {
        while (!stock.isEmpty()) {
            synchronized (buffer) {
                buffer.add(stock.getStuff());
                System.out.println("Ivanov get from stock");
            }
        }
        petrenko.stop();
    }
}
