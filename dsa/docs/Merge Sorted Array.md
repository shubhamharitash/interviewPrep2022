## Problem Statement
https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&id=top-interview-150

## Approaches
#### Approach 1(Using extra space)
Here we use an extra array for merging and then replace contents of first array.

###### Code
```java
class Solution {

public void merge(int[] nums1, int m, int[] nums2, int n) {

int[] nums = new int[m+n];

int i=0,j=0,k=0;

while(i<m && j<n){

if(nums1[i] < nums2[j]){

nums[k++] = nums1[i++];

} else {

nums[k++] = nums2[j++];

}

}

while(i<m)

nums[k++] = nums1[i++];

while(j<n)

nums[k++] = nums2[j++];

for(i=0; i<m+n; i++)

nums1[i] = nums[i];

// System.out.println(Arrays.toString(nums));

// nums1 = nums;

}

}
```

#### Approach 2(Without Extra Space)
#ImpQuestionTwoPointer 
3 pointers
last of first arr
last of second arr
last of result

max element of first two pointers is addedto the result.
Result is stored in first array.
###### Code
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n -1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(i>=0)
            nums1[k--] = nums1[i--];
        while(j>=0)
            nums1[k--] = nums2[j--];
    }
}
```