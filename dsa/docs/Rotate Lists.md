## Problem Statement
https://leetcode.com/problems/rotate-list/

## Approaches
#### Approach 1
![[Rotate Lists-1676100530371.jpeg]]

###### Code
```java
public int computeLength(ListNode head){
	int cnt = 0;
	while(head != null){
		cnt++;
		head = head.next;
	}
	return cnt;
}
public ListNode rotateRight(ListNode head, int k) {
	int l = computeLength(head);
	if(l == 0 || k == 0)
		return head;
	int actualRotations = k%l;
	if(actualRotations == 0)
		return head;
	ListNode pointer = head;
	for(int i=0; i<(l - actualRotations -1); i++){
		pointer = pointer.next;
	}
	System.out.println(pointer.val);
	ListNode next = pointer.next;
	pointer.next = null;
	ListNode temp = next;
	while(next.next != null){
		next = next.next;
	}
	next.next = head;
	return temp;
}
```