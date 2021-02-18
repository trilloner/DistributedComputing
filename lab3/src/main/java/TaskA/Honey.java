package TaskA;

public class Honey {

    static int honeyMax;
    static int temp = 0;

    public Honey(int honeyMax) {
        this.honeyMax = honeyMax;
    }

    synchronized void addHoney(Long id) throws InterruptedException {
        while (isFull()) {
            wait();
            System.out.println("Pot is full. Bear is coming");
        }

        temp++;
        System.out.println("Bee-" + id + " bring honey to the pot. Now size is: " + temp);
        Thread.sleep(1000);

    }

    synchronized boolean isFull() {
        return honeyMax == temp;
    }

    synchronized void eatHoney() {
        temp = 0;
        notifyAll();

    }
}
