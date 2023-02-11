## Problem Statement
https://leetcode.com/problems/intersection-of-two-linked-lists/

## Approaches
#### Approach 1
Compute Length and find the middle by iterating to the middle node

#### Approach 2
![[Intersection of Two Linked Lists-1675787559590.jpeg]]

###### Code
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

if(headA == null || headB == null)

return null;

ListNode pointer1 = headA;

ListNode pointer2 = headB;

while(pointer1 != pointer2){

pointer1 = pointer1 != null ? pointer1.next: headB;

pointer2 = pointer2 != null ? pointer2.next: headA;

}

return pointer1;

}
```