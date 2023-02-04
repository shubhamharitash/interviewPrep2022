## Problem Statement
https://leetcode.com/problems/swap-nodes-in-pairs

## Approaches
#### Approach 1
![[Swap nodes in pairs-1675490320426.jpeg]]

###### Code
```java
public ListNode swapPairs(ListNode head) {

if(head == null || head.next == null)

return head;

ListNode nextNode = head.next;

ListNode nextToNextNode = swapPairs(nextNode.next);

nextNode.next = head;

head.next = nextToNextNode;

return nextNode;

}
```

