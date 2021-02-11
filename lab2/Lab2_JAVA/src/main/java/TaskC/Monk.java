package TaskC;

import java.util.Random;
import java.util.function.Supplier;

public class Monk implements Supplier<Monk> {
    private final String name;
    private final int energy;
    Random randomEnergy = new Random();


    public Monk(String name) {
        this.name = name;
        this.energy = randomEnergy.nextInt(10);
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }

    public static Monk getWinner(Monk firstFighter, Monk secondFighter) {
        return firstFighter.getEnergy() > secondFighter.getEnergy()
                ? firstFighter : secondFighter;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name=" + name + '}';
    }

    @Override
    public Monk get() {
        return this;
    }
}
