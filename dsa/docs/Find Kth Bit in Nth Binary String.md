## Problem Statement
https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

## Approaches
#### Approach 1
[Recursion](https://1drv.ms/u/s!Atzh_D_Amn0nqinP67H_5WHjG5OW?e=eYMIdW)
Mathematical approach needed with indexes.

###### Code
```java
public static boolean solve(int n, int k){

if(n == 1)

return false;

if(k < n/2)

return solve(n/2, k);

else if(k == n/2)

return true;

return !solve(n/2, n-k-1);

}

public char findKthBit(int n, int k) {

System.out.println((1<<n) - 1);

return solve((1<<n) - 1, k-1) ? '1':'0';

}
```

