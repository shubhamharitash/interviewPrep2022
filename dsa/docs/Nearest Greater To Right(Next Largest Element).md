## Problem Statement
Given an array if int, we need to compute nearest greater element from index to the right
Eg:
I/P
| 1   | 3   | 2   | 4    |
| --- | --- | --- | --- |
Ans
| 3   | 4   | 4  | -1  | 
| --- | --- | --- | --- |

Explanation
For 1
| 1 | ==3== | ==2== | ==4== |
|---|---|---|---|
are considered, since 3 is nearest greater it is the answer
For 3
| 1 | 3 | ==2== | ==4== |
|---|---|---|---|
are considered, since 4 is nearest greater it is the answer

## Approaches
#### Approach 1(mine)
What we know
Stack is based on last in first out

###### Building logic
4->2->3->1
4->2->3   1->
1:3  4->2  3->
1:3  4 3->2  
1:3, 3:4, 2:4 4->
1:3, 3:4, 2:4, 4:-1

Here first stack is not needed since it is not serving any purpose

###### Algorithm
1) We use one stacks
2) iterate from left to right in loop
3) ele = arr[i]
	1) Check top of stack
		1) if nothing or top > ele, insert ele to stack
		2) if top < ele
			1) keep popping till top < ele and assign ele as answer for them
			2) insert ele to stack
4) If elements there in stack, pop all and assign answer for them as -1

###### Code
```java
public static long[] nextLargerElement(long[] arr, int n) {  
    Stack<Integer> stack = new Stack<>();  
    long[] res = new long[arr.length];  
    Arrays.fill(res, -1);  
    for (int i = 0; i < n; i++) {  
        if (stack.empty() || arr[stack.peek()] >= arr[i]) {  
            stack.push(i);  
        } else {  
            while (!stack.empty() && arr[stack.peek()] < arr[i]) {  
                res[stack.peek()] = arr[i];  
                stack.pop();  
            }  
            stack.push(i);  
        }  
    }  
    while (!stack.empty()) {  
        res[stack.pop()] = -1;  
    }  
    return res;  
}
```

#### Approach 2(Aditya verma one)
Similar to approach, difference being we iterate from right to left

###### Code
```java
public static long[] nextLargerElement(long[] arr, int n) {
	Stack<Integer> stack = new Stack<>();
	long[] res = new long[arr.length];
	Arrays.fill(res, -1);
	for (int i = n - 1; i >= 0; i--) {
		while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
			stack.pop();
		}
		res[i] = !stack.empty() ? arr[stack.peek()] : -1;
		stack.push(i);
	}
	return res;
}
```