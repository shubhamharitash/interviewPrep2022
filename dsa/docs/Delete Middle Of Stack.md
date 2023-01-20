## Problem Statement
Delete middle of stack using recursion

## Approaches
#### Approach 1
[[recursionDeleteMiddleOfStack.pdf]]

###### Code
```java
public void deleteMidHelper(Stack<Integer>s, int index){
        if(index == 0){
            s.pop();
            return;
        }
        int temp = s.pop();
        deleteMidHelper(s, index - 1);
        s.push(temp);
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        deleteMidHelper(s, sizeOfStack/2);
    } 
```

