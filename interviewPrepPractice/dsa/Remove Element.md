## Problem Statement
https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&id=top-interview-150

## Approaches
#### Approach 1
Push Logic

###### Code
```java
class Solution {
    public int removeElement(int[] arr, int val) {
        // Use push logic
        int ptr = 0; // will always point to equal element
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=val){
                int t = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = t;
                ptr++;
            } else {
                cnt++;
            }
        }
        return arr.length - cnt;
    }
}
```