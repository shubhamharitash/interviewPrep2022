## Problem Statement
https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

## Approaches
#### Approach 1
Simple I/P and O/P recursion

###### Code
```java
ArrayList<String> solve(String s, String output) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add(output);
            return res;
        } else if (s.length() == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(output + s.charAt(0));
            return res;
        }
        ArrayList<String> r2 = solve(s.substring(1),  output + s.charAt(0) + " ");
        ArrayList<String> r1 = solve(s.substring(1),  output + s.charAt(0));
        r2.addAll(r1);
        return r2;
    }

    ArrayList<String> permutation(String S) {
        return solve(S, "");
    }
```

