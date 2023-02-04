package algorithms.recursion.theory;

import java.util.ArrayList;
import java.util.List;

public class Q9_PermutationWithSpaces {
    public static ArrayList<String> solve(String s, String output) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add(output);
            return res;
        } else if (s.length() == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(output + s.charAt(0));
            return res;
        }
//        System.out.printf("%s & %s\n", s, output);
        ArrayList<String> r2 = solve(s.substring(1),  new String(output + s.charAt(0) + " "));
//        System.out.printf("%s & %s\n", s, output);
        ArrayList<String> r1 = solve(s.substring(1),  new String(output + s.charAt(0)));
        System.out.printf("%s & %s & %s\n", r1, r2, output);
        r2.addAll(r1);
        return r2;
    }

    public static ArrayList<String> permutation(String S) {
        return solve(S, "");
    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
}
