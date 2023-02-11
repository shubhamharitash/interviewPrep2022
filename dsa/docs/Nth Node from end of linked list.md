## Problem Statement
Find $n^{th}$ node from the end of the linked list 

## Approaches
#### Approach 1
1) Compute length in first iteration
2) find length - $n^{th}$ element

#### Approach 2
1) Use two pointers, slow and fast. fast pointer will be **n** steps ahead
2) move both pointers ahead till fast pointer becomes null.
3) slowPointer will have the answer.

###### Code
```java
int getNthFromLast(Node head, int n)
    {
    	// Your code here	
    	Node slow = head;
    	Node fast = head;
    	int length = 0;
    	while(head!=null){
    	    head = head.next;
    	    length++;
    	}
    	if(n > length){
    	    return -1;
    	}
    	for(int i=0;i<n;i++){
    	    if(fast!=null){
    	        fast = fast.next;
    	    }
    	}
    	while(fast!=null){
    	    slow = slow.next;
    	    fast = fast.next;
    	}
    	return slow.data;
    }
```