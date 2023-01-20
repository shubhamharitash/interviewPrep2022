## Problem Statement
Given an array with building heights, find maximum area of rectangle which we can form
![[Maximum Area of Histogram-1673789082048.jpeg]]
I/P: 6 2 5 4 5 1 6
O/P: maximum area of rectangle = 4 X 3 = 12

## Approaches
#### Approach 1
Convert question to a known pattern
lets compute **nearest smaller element to left(NSL)** and **nearest smaller element to right(NSR)** arrays.
I/P: 6 2 5 4 5 1 6
NSL: -1, -1, 1, 1, 3, -1, 5
NSR: 1, 5, 3, 5, 5, 7, 7

length of rectangle they can be part of
length = nsr[i] - nsl[i] -1
width = arr[i]
area = length * width

res = Math.max(res, area)

###### Code
```java
public static int[] nearestSmallerToLeft(int[] arr, int n) {  
    Stack<Integer> stack = new Stack<>();  
    int[] res = new int[arr.length];  
    for (int i = 0; i < n; i++) {  
        while (!stack.empty() && arr[stack.peek()] >= arr[i]) {  
            stack.pop();  
        }  
        res[i] = !stack.empty() ? stack.peek() : -1;  
        stack.push(i);  
    }  
    return res;  
}  
  
public static int[] nearestSmallerToRight(int[] arr, int n) {  
    Stack<Integer> stack = new Stack<>();  
    int[] res = new int[arr.length];  
    for (int i = n - 1; i >= 0; i--) {  
        while (!stack.empty() && arr[stack.peek()] >= arr[i]) {  
            stack.pop();  
        }  
        res[i] = !stack.empty() ? stack.peek() : n;  
        stack.push(i);  
    }  
    return res;  
}  
  
public int largestRectangleArea(int[] heights) {  
    int[] nsl = nearestSmallerToLeft(heights, heights.length);  
    int[] nsr = nearestSmallerToRight(heights, heights.length);  
    int res = Integer.MIN_VALUE;  
    for (int i = 0; i < heights.length; i++) {  
        int length = nsr[i] - nsl[i] - 1;  
        int width = heights[i];  
        res = Math.max(res, length * width);  
    }  
    return res;  
}
```

