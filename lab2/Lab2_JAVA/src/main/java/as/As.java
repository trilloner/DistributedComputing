package as;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

class As {
    int a;

    static {
        System.out.println("before class");
    }

    public As(int a) {
        this.a = a;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "" + a;
    }

    public static void main(String[] args) throws Exception {
        HashSet<As> set = new HashSet<>();
        As a = new As(3);
        set.add(a);

        set.add(new As(2));
        set.add(new As(2));
        set.stream().forEach(System.out::println);
    }
}
