package TaskC;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Arena extends RecursiveTask<Monk> {

    private final List<Monk> firstMonk;
    private final List<Monk> secondMonk;
    private int start, end;

    public Arena(List<Monk> firstMonk, List<Monk> secondMonk, int start, int end) {
        this.firstMonk = firstMonk;
        this.secondMonk = secondMonk;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Monk compute() {
        if (end - start == 0) {
            System.out.println("Arena with: " + firstMonk.get(end) + " and " + secondMonk.get(end));
            return Monk.getWinner(firstMonk.get(end), secondMonk.get(end));
        }
        Arena leftWinner = new Arena(firstMonk, secondMonk, start, (end + start) / 2);
        leftWinner.fork();

        Arena rightWinner = new Arena(firstMonk, secondMonk, (end + start) / 2 + 1, end);
        rightWinner.fork();

        Monk left = leftWinner.join();
        Monk right = rightWinner.join();

        System.out.println("Arena with: " + left + " and " + right);


        return Monk.getWinner(left, right);
    }
}
