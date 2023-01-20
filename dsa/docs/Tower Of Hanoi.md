## Problem Statement
https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

## Approaches
#### Approach 1
![[Tower Of Hanoi-1674151672553.jpeg]]

###### Code
```java
public long toh(int n, int f, int t, int a) {
        // Your code here
        if(n==1) {
            System.out.printf("move disk %d from rod %d to rod %d\n", n, f, t);
            return 1L;
        }
        long res =  toh(n-1, f, a, t);
        System.out.printf("move disk %d from rod %d to rod %d\n", n, f, t);
        return 1 + res + toh(n-1, a, t, f);
    }
```

