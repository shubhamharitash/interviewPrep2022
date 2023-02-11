## Problem Statement
https://leetcode.com/problems/delete-node-in-a-linked-list/description/

## Approaches
#### Approach 1
![[Delete Node-1675904738872.jpeg]]

###### Code
```java
public void deleteNode(ListNode node) {

node.val = node.next.val;

node.next = node.next.next;

}
```