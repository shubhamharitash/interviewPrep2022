## Problem Statement
https://leetcode.com/problems/merge-in-between-linked-lists/description/

## Approaches
#### Approach 1
Simple implementation based

###### Code
```java
public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;
        for(int i=0;i<a-1;i++){
            start = start.next;
        }
        for(int i=0;i<b+1;i++){
            end = end.next;
        }
        start.next = list2;
        while(list2.next!=null){
            list2 = list2.next;
        }
        list2.next = end;
        return list1;
    }
```