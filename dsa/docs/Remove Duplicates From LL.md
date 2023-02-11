## Problem Statement
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

## Approaches
#### Approach 1
![[Remove Duplicates From LL-1675787387172.jpeg]]

###### Code
```java
public ListNode deleteDuplicates(ListNode head) {

if(head == null)

return head;

ListNode subRes = deleteDuplicates(head.next);

if(subRes!=null && head.val == subRes.val){

head.next = null;

return subRes;

}

head.next = subRes;

return head;

}
```

