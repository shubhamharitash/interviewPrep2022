## Problem Statement

## Approaches
#### Approach 1(O(n))
![[Candy-1679842726467.jpeg]]
We create an increasing and decreasing array, add its elements to a resultant array.
If any element of res is 0 then we account for it by adding n else we calculate sum and return the result.

###### Code
```java
class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] incArr = new int[n];
        int[] decArr = new int[n];
        int[] res = new int[n];
        boolean flag = false;
        for(int i=1; i<n; i++){
            if(rating[i-1] < rating[i])
                incArr[i] = incArr[i-1] + 1;
        }
        for(int i=n-2; i>=0; i--){
            if(rating[i+1] < rating[i])
                decArr[i] = decArr[i+1] + 1;
        }
        for(int i=0; i<n; i++){
            res[i] = Math.max(incArr[i], decArr[i]);
            if(!flag && res[i]==0)
                flag = true;
        }
        return flag==true?Arrays.stream(res).sum() + n:Arrays.stream(res).sum();
    }
}
```