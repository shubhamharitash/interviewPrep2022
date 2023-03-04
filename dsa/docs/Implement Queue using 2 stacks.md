## Problem Statement
https://leetcode.com/problems/implement-queue-using-stacks/description/

## Approaches
#### Approach 1
![[Implement Queue using 2 stacks-1676748054151.jpeg]]

###### Code
```java
class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(!stk2.isEmpty()){
            return stk2.pop();
        }
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        return stk2.pop();
    }
    
    public int peek() {
        if(!stk2.isEmpty()){
            return stk2.peek();
        }
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        return stk2.peek();
    }
    
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
}
```