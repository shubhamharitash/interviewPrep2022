## Problem Statement
Given an array with heights of buildings, water is poured from above. Calculate rainwater
![[RainWater Trapping-1673913121299.jpeg]]

## Approaches
#### Approach 1(Using stacks)
Time Complexity: O(n)
Space Complexity: O(n)
1) Compute nearestGreaterToRight with modifications
	1) Equal elements to be included
	2) lastPopped to be maintained and it will be answer if no greater than or equal to element exist
2) Compute prefixSum
3) iterate heights, if height[i] != 0 && ngr[i] != -1
	1) Compute area and add to result
	2) else move ahead

###### Code
```java
public static int[] nearestGreaterToRight(int[] height) {  
    int[] res = new int[height.length];  
    Stack<Integer> stack = new Stack<>();  
    for (int i = height.length - 1; i >= 0; i--) {  
        int lastPopped = -1;  
        while (!stack.empty() && height[stack.peek()] < height[i]) {  
            lastPopped = stack.pop();  
        }  
        res[i] = stack.empty() ? lastPopped : stack.peek();  
        stack.push(i);  
    }  
    return res;  
}  
  
public static int[] prefixSum(int[] arr) {  
    int[] res = new int[arr.length];  
    res[0] = arr[0];  
    for (int i = 1; i < arr.length; i++) {  
        res[i] = res[i - 1] + arr[i];  
    }  
    return res;  
}  
  
public static int trap(int[] height) {  
    int[] ngr = nearestGreaterToRight(height);  
    int[] prefixSumArr = prefixSum(height);  
    int i = 0;  
    int res = 0;  
    while (i < height.length) {  
        if (height[i] != 0 && ngr[i] != -1) {  
            int length = Math.min(height[i], height[ngr[i]]);  
            int width = ngr[i] - i - 1;  
            int debrisArea = prefixSumArr[ngr[i] - 1] - prefixSumArr[i];  
            res += length * width - debrisArea;  
            i = ngr[i];  
        } else {  
            i++;  
        }  
    }  
    return res;  
}
```

#### Approach 2(Using DP)(Aditya verma solution)
Time Complexity: O(n)
Space Complexity: O(n)

1) Construct maximum left(ml) and maximum right(mr) array
2) rainwater at each building min(mr[i] - ml[i])- height[i]

#### Approach 3(Using Two Pointers)
Time Complexity: O(n)
Space Complexity: O(1)

###### Code
```java
public int trap(int[] height) {
        // time : O(n)
        // space : O(1)
	if (height.length==0) return 0; 
	int left = 0, right = height.length-1; 
	int leftMax=0, rightMax=0; 
	int ans = 0; 
	while (left < right) {
		if (height[left] > leftMax) leftMax = height[left]; 
		if (height[right] > rightMax) rightMax = height[right];
		if (leftMax < rightMax) {
			ans += Math.max(0, leftMax-height[left]); 
			left++; 
		} else {
			ans += Math.max(0, rightMax-height[right]); 
			right--; 
		}
	}
	return ans; 
}
```