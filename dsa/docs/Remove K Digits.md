## Problem Statement
https://leetcode.com/problems/remove-k-digits/description/

## Approaches
#### Approach 1
Here stack is used to store encountered elements in ascending order.
When we encounter element smaller than peek, we start popping from stack
Extra checks
1) We pop preceeding 0s
2) For scenario like 1 2 3 4, we have a seperate loop at the end of first iteration.

###### Code
```java
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k)
            return "0";
        if(k==0)
            return num;
        Stack<Character> stk = new Stack<>();
        stk.push(num.charAt(0));
        // Main Logic
        for(int i=1; i<num.length(); i++){
            while(k>0 && !stk.isEmpty() && stk.peek()>num.charAt(i)){
                k--;
                stk.pop();
            }
            stk.push(num.charAt(i));
            // Popping preceeding zeroes
            if(stk.size()==1 && num.charAt(i)=='0')
                stk.pop();
        }
        StringBuilder res = new StringBuilder();
        // for scenario like 1234
        while(k>0 && !stk.isEmpty()){
            stk.pop();
            k--;
        }
        while(!stk.isEmpty()){
            res.insert(0, stk.pop());
        }
        if(res.length()==0)
            return "0";
        return res.toString();
    }
}
```