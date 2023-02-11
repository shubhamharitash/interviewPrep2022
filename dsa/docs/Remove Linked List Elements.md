## Problem Statement
https://leetcode.com/problems/remove-linked-list-elements/

## Approaches
#### Approach 1
Simple Recursion

###### Code
```java
public ListNode removeElements(ListNode head, int val) {

if(head == null)

return head;

ListNode subRes = removeElements(head.next, val);

if(head.val == val){

return subRes;

}

head.next = subRes;

return head;

}
```

