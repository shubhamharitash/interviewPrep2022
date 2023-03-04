## Problem Statement
https://leetcode.com/problems/count-sorted-vowel-strings/description/

## Approaches
#### Approach 1
![[Count Sorted Vowel Strings-1677944438269.jpeg]]
Simple pattern based.

###### Code
```java
class Solution {
    public static int sumArr(int[] arr, int start, int end){
        int sum = 0;
        for(int i=start; i<=end; i++){
            sum+=arr[i];
        }
        return sum;
    }
    public int countVowelStrings(int n) {
        int[] temp = {5,4,3,2,1};
        for(int i=0; i<n-1; i++){
            for(int j=0; j<4; j++){
                temp[j] = sumArr(temp, j, 4);
            }
        }
        return temp[0];
    }
}
```

#### Approach 2
Combination number
![[Count Sorted Vowel Strings-1677946443077.jpeg]]

###### Code
```java
public int countVowelStrings(int n) {
	return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
}
```