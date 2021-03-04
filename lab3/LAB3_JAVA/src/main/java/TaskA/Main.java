package TaskA;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Main {
    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {

        Honey honey = new Honey(10);
        Bear bear = new Bear(honey);
        new Thread(bear).start();
        new Thread(new Bee(honey, bear)).start();
        new Thread(new Bee(honey, bear)).start();
        new Thread(new Bee(honey, bear)).start();
        new Thread(new Bee(honey, bear)).start();
        new Thread(new Bee(honey, bear)).start();
        ConcurrentHashMap map = new ConcurrentHashMap();

    }
}
