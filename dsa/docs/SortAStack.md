## Problem Statement
Sort a stack using recursion

## Approaches
#### Approach 1
[[recursionSortAStack.pdf]]

###### Code
```java
class GfG{
    public static void insertEleAtCorrectPos(Stack<Integer> s, Integer ele) {
        if(s.size() == 0 || ele > s.peek()){
            s.push(ele);
            return;
        }
        Integer temp = s.pop();
        insertEleAtCorrectPos(s, ele);
        s.push(temp);
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.size() == 0)
		    return s;
	    int ele = s.pop();
	    sort(s);
	    insertEleAtCorrectPos(s, ele);
	    return s;
	}
}
```

