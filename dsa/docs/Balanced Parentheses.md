## Problem Statement
https://leetcode.com/problems/generate-parentheses/description/

## Approaches
#### Approach 1
![[Balanced Parentheses-1675318585927.jpeg]]

###### Code
```java
public static List<String> solve(int n, String output, int openCount){

if(n==0){

StringBuilder str = new StringBuilder(output);

for(int i=0; i<openCount; i++){

str = str.append(")");

}

List<String> res = new ArrayList<>();

res.add(str.toString());

return res;

}

List<String> r1 = solve(n-1, output + "(", openCount + 1);

List<String> r2 = new ArrayList<>();

if(openCount != 0)

r2 = solve(n, output + ")", openCount - 1);

r1.addAll(r2);

return r1;

}

public List<String> generateParenthesis(int n) {

return solve(n, "", 0);

}
```

