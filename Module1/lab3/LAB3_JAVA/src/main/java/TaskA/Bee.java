package TaskA;

public class Bee implements Runnable {

    private Honey med;
    private volatile boolean isWorking;
    private Bear bear;


    public Bee(Honey med, Bear bear) {
        this.med = med;
        this.isWorking = true;
        this.bear = bear;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Long threadId = Thread.currentThread().getId();
                Thread.sleep(1000);
                med.addHoney(threadId);
                if (med.isFull()) {
                    bear.wakeUpBear();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
