## Problem Statement
Given a linked list and a value K, partition it such that all nodes less than K come before nodes greater than or equal to K. You should preserve the original relative order of the nodes in each of the two partitions. For example, given 1->4->3->2->5->2 and K = 3, return 1->2->2->4->3->5.

## Approaches
#### Approach 1
Pseudohead logic
1) Create Two Pseudolists
2) while iterating insert elements to relevant lists.
3) combine both lists
4) return res

###### Code
```java
public ListNode partition(ListNode head, int x) {
        ListNode newHeadList1 = new ListNode();
        ListNode curList1 = newHeadList1;
        ListNode newHeadList2 = new ListNode();
        ListNode curList2 = newHeadList2;
        while(head!=null){
            ListNode next = head.next;
            head.next = null;
            if(head.val<x){
                curList1.next = head;
                curList1 = curList1.next;
            } else {
                curList2.next = head;
                curList2 = curList2.next;
            }
            head = next;
        }
        curList1.next = newHeadList2.next;
        return newHeadList1.next;
    }
```