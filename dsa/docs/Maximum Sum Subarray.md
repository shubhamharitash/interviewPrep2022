## Problem Statement
https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
![[Maximum Sum Subarray-1676786330799.jpeg]]

###### Code
```java
static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
	long sum = 0;
	long maxSum = 0;
	for(int i=0;i<k;i++){
		sum+=arr.get(i);
	}
	maxSum = sum;
	for(int i=1;i<n-k+1;i++){
		sum = sum + arr.get(i+k-1) - arr.get(i-1);
		if(maxSum < sum){
			maxSum = sum;
		} 
	}
	return maxSum;
}
```