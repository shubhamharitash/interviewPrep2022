## Problem Statement
https://leetcode.com/problems/k-th-symbol-in-grammar/

## Approaches
#### Approach 1
![[Kth Grammer-1674150128869.jpeg]]

###### Code
```java
public int kthGrammar(int n, int k) {  
    if (n == 1)  
        return 0;  
    int mid = (1<<(n-1))/2;  
    if (k <= mid)  
        return kthGrammar(n - 1, k);  
    else  
        return kthGrammar(n - 1, k - mid) == 0 ? 1:0;  
}
```

