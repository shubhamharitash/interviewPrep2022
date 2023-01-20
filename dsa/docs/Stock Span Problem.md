## Problem Statement
The stock span problem is a financial problem where we have a series of **n** daily price quotes for a stock and we need to calculate the span of stocks price for all **n** days.   
The span **Si** of the stocks price on a given day **i** is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.  
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

## Approaches
#### Approach 1
Zerox copy of [[Nearest Greater To Left]] only difference being computing logic

###### Code
```java
public static int[] calculateSpan(int arr[], int n) {
	Stack<Integer> stack = new Stack<>();
	int[] res = new int[arr.length];
	for (int i = 0; i < n; i++) {
		while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
			stack.pop();
		}
		res[i] = i - (stack.empty() ? -1 : stack.peek());
		stack.push(i);
	}
	return res;
}
```

