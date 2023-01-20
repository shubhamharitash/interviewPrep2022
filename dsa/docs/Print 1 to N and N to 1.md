## Problem Statement
Print 1 to N and N to 1

## Approaches
#### Approach 1
Simple problem just informs where to call recursive function

Approach learned
Induction, base and hypothesis.
![[Print 1 to N and N to 1-1674064941556.jpeg]]

![[Print 1 to N and N to 1-1674065486511.jpeg]]

###### Code
1 to n
```java
public void printNos(int n)
{
	if(n==0)
		return;
	printNos(n-1);
	System.out.print(n + " ");
}
```

n to 1
```java
public void printNos(int n)
    {
        if(n==0)
            return;
        printNos(n-1);
        System.out.print(n + " ");
    }
```