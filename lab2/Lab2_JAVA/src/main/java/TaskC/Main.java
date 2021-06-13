package TaskC;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final int MONASTERY = 2;
    private static final int MONKS = 16;
    private static final StringBuilder winner = new StringBuilder("The winner is: ");

    public static void main(String[] args) {
        List<Monk> firstMonks = Stream.generate(new Monk("NihAK"))
                .limit(MONKS)
                .collect(Collectors.toList());

        List<Monk> secondMonks = Stream.generate(new Monk("HyaHu"))
                .limit(MONKS)
                .collect(Collectors.toList());
        ForkJoinPool pool = new ForkJoinPool(MONASTERY);
        winner.append(pool.invoke(new Arena(firstMonks, secondMonks, 0, MONKS - 1)));
        System.out.println(new String(winner));

    }
}
