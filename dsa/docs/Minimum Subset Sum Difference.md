## Problem Statement
https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
![[Minimum Subset Sum Difference-1677004140418.jpeg]]

###### Code
```java
public int minDifference(int arr[], int n) 
	{ 
	    int sum = Arrays.stream(arr).sum();
	    boolean[][] dp = new boolean[arr.length+1][sum+1];
	    for(int i=0; i<=arr.length; i++){
	        dp[i][0] = true;
	    }
	    for(int i=1; i<=arr.length; i++){
	        for(int j=1; j<=sum; j++){
	            if(j>=arr[i-1]){
	                dp[i][j] = dp[i-1][j-arr[i-1]];
	            }
	            dp[i][j] = dp[i][j] || dp[i-1][j];
	        }
	    }
	    for(int i=sum/2; i>=0; i--){
	        if(dp[arr.length][i]){
	            return sum - 2*i;
	        }
	    }
	    return 0;
	}
```