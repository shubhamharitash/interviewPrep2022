## Problem Statement
https://leetcode.com/problems/implement-stack-using-queues/description/

## Approaches
#### Approach 1
![[Implement Stack using 2 queues-1676749464471.jpeg]]

###### Code
```java
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q2.add(x);
            return;
        }
        q1.add(x);
    }

    public int pop() {
        Queue<Integer> emptyQueue = q1.isEmpty() ? q1 : q2;
        Queue<Integer> nonEmptyQueue = !q1.isEmpty() ? q1 : q2;
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.remove());
        }
        return nonEmptyQueue.remove();
    }

    public int top() {
        Queue<Integer> emptyQueue = q1.isEmpty() ? q1 : q2;
        Queue<Integer> nonEmptyQueue = !q1.isEmpty() ? q1 : q2;
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.add(nonEmptyQueue.remove());
        }
        if(!nonEmptyQueue.isEmpty()){
            Integer val = nonEmptyQueue.peek();
            emptyQueue.add(nonEmptyQueue.remove());
            return val;
        }
        return -1;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
```