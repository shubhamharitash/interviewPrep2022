## Problem Statement
Similiar to [[Nearest Greater To Right(Next Largest Element)]] with a slight variation

## Approaches
#### Approach 1
Similiar logic but this time we will change stack logic to pop greater than or equal to elements.

###### Code
```java
public static long[] nearestSmallerToRight(long[] arr, int n) {  
    Stack<Integer> stack = new Stack<>();  
    long[] res = new long[arr.length];  
    Arrays.fill(res, -1);  
    for (int i = n - 1; i >= 0; i--) {  
        while (!stack.empty() && arr[stack.peek()] >= arr[i]) {  
            stack.pop();  
        }  
        res[i] = !stack.empty() ? arr[stack.peek()] : -1;  
        stack.push(i);  
    }  
    return res;  
}
```