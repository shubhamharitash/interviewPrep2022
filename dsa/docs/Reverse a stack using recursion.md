## Problem Statement
Reverse a stack using recursion

## Approaches
#### Approach 1
Simple induction base hypothesis application

###### Code
```java
public static void insertEleAtEnd(Stack<Integer> stk, Integer ele){
        if(stk.size() == 0){
            stk.push(ele);
            return;
        }
        int temp = stk.pop();
        insertEleAtEnd(stk, ele);
        stk.push(temp);
    }
    
    static void reverse(Stack<Integer> s)
    {
        if(s.size() == 0)
            return;
        int temp = s.pop();
        reverse(s);
        insertEleAtEnd(s, temp);
    }
```

