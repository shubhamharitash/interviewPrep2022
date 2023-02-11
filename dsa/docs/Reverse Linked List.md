## Problem Statement
https://leetcode.com/problems/reverse-linked-list/

## Approaches
#### Approach 1
![[Reverse Linked List-1675708845034.jpeg]]
We can use temp instead of using a next pointer 😄

###### Code
```java
public static ListNode reverseLL(ListNode head){
	ListNode prev = null;
	while(head!=null){
		ListNode temp = head.next;
		head.next = prev;
		prev = head;
		head = temp;
	}
	return prev;
}
```

