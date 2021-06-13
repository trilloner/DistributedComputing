package TaskB;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private Vehicle truck;
    private Stock stock;
    private volatile Queue<Integer> buffer;
    private Ivanov ivanov;
    private Nechypurenko necheporchuk;
    private Petrenko petrov;
    private volatile Util switcher;
    private final int numberOfThings = 5;

    public static void main(String[] args) {
        Main mainClass = new Main();

        mainClass.start();
    }

    void start() {
        truck = new Vehicle();
        stock = new Stock(numberOfThings);
        buffer = new LinkedList<>();
        switcher = new Util();
        necheporchuk = new Nechypurenko(buffer, switcher, this);
        petrov = new Petrenko(buffer, truck, switcher, necheporchuk);
        ivanov = new Ivanov(stock, buffer, petrov);

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(truck);
    }
}
