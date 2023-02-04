## Problem Statement
https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
Variation of [[Balanced Parentheses]]

###### Code
```java
public static ArrayList<String> solve(int n, String output, int count){
	if(n==0){
		ArrayList<String> res = new ArrayList<>();
		res.add(output);
		return res;
	}
	ArrayList<String> r1 = solve(n-1, output + "1", count + 1);
	ArrayList<String> r2 = new ArrayList<>();
	if(count != 0)
		r2 = solve(n - 1, output + "0", count - 1);
	r1.addAll(r2);
	return r1;
}

ArrayList<String> NBitBinary(int n) {
	// code here
	return solve(n, "", 0);
}
```

