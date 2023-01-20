## Problem Statement
Similiar to [[Nearest Greater To Right(Next Largest Element)]] with a slight variation

## Approaches
#### Approach 1
Similiar logic but this time we will iterate loop from opposite direction

###### Code
```java
public static long[] nearestGreaterToLeft(long[] arr, int n) {  
    Stack<Integer> stack = new Stack<>();  
    long[] res = new long[arr.length];  
    Arrays.fill(res, -1);  
    for (int i = 0; i < n; i++) {  
        while (!stack.empty() && arr[stack.peek()] <= arr[i]) {  
            stack.pop();  
        }  
        res[i] = !stack.empty() ? arr[stack.peek()] : -1;  
        stack.push(i);  
    }  
    return res;  
}
```

