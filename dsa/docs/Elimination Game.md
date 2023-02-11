## Problem Statement
https://leetcode.com/problems/elimination-game/description/

## Approaches
#### Approach 1
![[Elimination Game-1675627351780.jpeg]]

###### Code
```java
class Solution {

public int lastRemaining(int n) {

if(n==1)

return 1;

return 2*(n/2 + 1 - lastRemaining(n/2));

}

}
```

