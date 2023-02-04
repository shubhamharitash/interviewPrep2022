## Problem Statement
https://leetcode.com/problems/find-the-winner-of-the-circular-game/

## Approaches
#### Approach 1
![[Find the Winner of the Circular Game-1675351442778.jpeg]]

###### Code
```java
public int helper(int n, int k){

if(n==1)

return 0;

return (helper(n-1, k) + k)%n;

}

public int findTheWinner(int n, int k) {

return helper(n,k) + 1;

}
```

