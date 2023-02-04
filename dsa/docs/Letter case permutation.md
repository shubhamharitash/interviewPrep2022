## Problem Statement
https://leetcode.com/problems/letter-case-permutation/

## Approaches
#### Approach 1
Simple I/P and O/P approach with checks

###### Code
```java
public static List<String> solve(String s, String output) {

if (s.length() == 0) {

List<String> res = new ArrayList<>();

res.add(output);

return res;

}

if (Character.isAlphabetic(s.charAt(0))) {

List<String> r1 = solve(s.substring(1), output + Character.toLowerCase(s.charAt(0)));

List<String> r2 = solve(s.substring(1), output + Character.toUpperCase(s.charAt(0)));

r1.addAll(r2);

return r1;

}

return solve(s.substring(1), output + s.charAt(0));

}

  

public List<String> letterCasePermutation(String s) {

return solve(s, "");

}
```

