## Problem Statement
https://leetcode.com/problems/merge-two-sorted-lists/description/

## Approaches
#### Approach 1
![[Merge Two Lists-1675712260166.jpeg]]
###### Code
```java
public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

ListNode temp = new ListNode();

ListNode pointer = temp;

while(head1!=null && head2!=null){

if(head1.val <= head2.val){

pointer.next = head1;

head1 = head1.next;

} else {

pointer.next = head2;

head2 = head2.next;

}

pointer = pointer.next;

}

if(head1 == null)

pointer.next = head2;

else

pointer.next = head1;

temp = temp.next;

return temp;

}
```

