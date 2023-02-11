## Problem Statement
https://leetcode.com/problems/linked-list-cycle/description/

## Approaches
#### Approach 1
![[Linked List Cycle-1675791170680.jpeg]]

###### Code
```java
public boolean hasCycle(ListNode head) {

ListNode slowPtr = head;

ListNode fastPtr = head;

while(fastPtr!=null && fastPtr.next!=null){

slowPtr = slowPtr.next;

fastPtr = fastPtr.next.next;

if(slowPtr == fastPtr)

return true;

}

return false;

}
```

