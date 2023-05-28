## Problem Statement
https://leetcode.com/problems/gas-station/description/

## Approaches
#### Approach 1(Slower O(n))
Here we make use of two pointer approach using start and cur.

###### Code
```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int cur = 0;
        int remainingGas = 0;
        int n = gas.length;
        int cnt = 0;
        int totalGasAvailable = Arrays.stream(gas).sum();
        int totalGasCost = Arrays.stream(cost).sum();
        if(totalGasAvailable<totalGasCost)
            return -1;
        while(start<n){
            if(cnt==n && start==cur)
                return start;
            remainingGas += gas[cur]-cost[cur];
            if(remainingGas>=0){
                cur = (cur+1)%n;
                cnt++;
            } else {
                start = cur+1;
                cur++;
                cnt = 0;
                remainingGas = 0;
            }
        }
        return -1;
    }
}
```

#### Approach 2(Easy and optimized)
We know that if `totalGas==totalCost` then a solution is bound to be there. Using that we just calculate the index for which remainingGas doesn't become <0 while iterating list.

###### Code
```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total  = 0;
        int gasAvailable = 0;
        int index = 0;
        
        for(int i = 0; i < n; i++){
            total  += gas[i] - cost[i];
            gasAvailable += gas[i] - cost[i];
            if(gasAvailable < 0){
                gasAvailable = 0;
                index = i + 1;
            }
        }
        return (total  < 0) ? -1 : index;
    }
}
```