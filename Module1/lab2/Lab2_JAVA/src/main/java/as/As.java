package as;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

class As {

    public static String rec(String input) {
        String first = input.replaceAll("A", "AAB");
        String second = first.replaceAll("B", "BBA");
        String third = second.replaceAll("AAA", "");
        String fourth = third.replaceAll("BBB", "");
        return fourth;
    }

    public static void main(String[] args) throws Exception {
        int a = 1;
        int b = 1;
        String input = "BBAB";
        while (input.length() < 400) {
            input = rec(input);
        }
        for (char i : input.toCharArray()) {
            if (i == 'A')a++;
            if (i == 'B')b++;
        }
        System.out.println(input);
        System.out.println(a);
        System.out.println(b);
    }
}
