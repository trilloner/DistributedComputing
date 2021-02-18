package TaskA;

public class Bear implements Runnable {

    private Honey honey;
    private volatile boolean isAwake;

    public Bear(Honey honey) {
        this.honey = honey;
        this.isAwake = false;

    }

    public synchronized void wakeUpBear() {
        isAwake = true;
        notify();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (!isAwake){
                    try {
                        wait();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                honey.eatHoney();
                System.out.println("Bear ate all honey");

                isAwake = false;
            }
        }
    }
}
