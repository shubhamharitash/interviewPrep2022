## Problem Statement
https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

## Approaches
#### Approach 1
We iterate the list and compute sum while iterating. when second 0 encountered we add it.
![[Merge Nodes in Between Zeros-1675793567403.jpeg]]

###### Code
```java
public ListNode mergeNodes(ListNode head) {

int sum = 0;

/*

0 -> no zero encountered

1 -> first zero encountered

2 -> second zero encountered

*/

int flag = 0;

ListNode res = new ListNode();

ListNode pointer = res;

while(head!=null){

if(flag == 0 && head.val == 0){

flag = 1;

} else if(flag == 1 && head.val != 0){

sum += head.val;

} else if(flag == 1 && head.val == 0){

pointer.next = new ListNode(sum);

pointer = pointer.next;

sum = 0;

}

head = head.next;

}

return res.next;

}
```