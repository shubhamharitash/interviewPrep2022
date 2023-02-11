## Problem Statement
https://leetcode.com/problems/insertion-sort-list/description/

## Approaches
#### Approach 1
![[Insertion Sort Linked Lists-1676097812951.jpeg]]
Psedohead makes it a cakewalk.

In case of arrays, we need to shift elements to insert at correct position but here we just need to find the correct position and arrange pointers
###### Code
```java
public ListNode insertionSortList(ListNode head) {
	ListNode dummy = new ListNode();
	ListNode curEle = head;
	while(curEle!=null){
		ListNode prevNode = dummy;
		while(prevNode.next!=null && prevNode.next.val <= curEle.val){
			prevNode = prevNode.next;
		}
		// prevNode.next will be greater or null at this stage
		ListNode next = curEle.next;
		curEle.next = prevNode.next;
		prevNode.next = curEle;
		curEle = next;
	}
	return dummy.next;
}
```