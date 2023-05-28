## Problem Statement

## Approaches
#### Approach 1(Arrangement)
We recognize the arrangement pattern in the problem, arrange that using loop.
temp boolean array is used for breaking cycles
![[Rotate Array-1683577394356.jpeg]]

###### Code
```java
class Solution {
    public void rotate(int[] arr, int k) {
        k = k%arr.length;
        if(k==0)
            return;
        int n = arr.length;
        int ele = -1;
        int index = 0;
        boolean[] temp = new boolean[arr.length];
        while(n>0){
            if(temp[index]){
                ele = -1;
                index = (index + 1)%arr.length;
                continue;
            }
            int newIndex = (index + k)%arr.length;
            if(ele==-1){
                ele = arr[newIndex];
                arr[newIndex] = arr[index];
            } else {
                int newEle = arr[newIndex];
                arr[newIndex] = ele;
                ele = newEle;
            }
            temp[index] = true;
            index = newIndex;
            n--;
        }
    }
}
```

#### Approach 2(Reverse Components)
Realizing that answer = reversing some components
![[Rotate Array-1683577595142.jpeg]]

###### Code
```java
class Solution {
    public static void reverseArr(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length;
        reverseArr(nums, 0, n - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, n - 1);
    }
}
```