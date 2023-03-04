## Problem Statement
https://leetcode.com/problems/merge-k-sorted-lists/description/

## Approaches
#### Approach 1
1) Here we use min heap to find minimum in all the linked lists at each instance.

###### Code
```java
class Solution {
    class Pair {
        ListNode data;
        int listIndex;

        public Pair(ListNode data, int listIndex) {
            this.data = data;
            this.listIndex = listIndex;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.data.val));
        ListNode head = new ListNode();
        ListNode pointer = head;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)
                pq.add(new Pair(lists[i], i));
        }
        while (!pq.isEmpty()) {
            Pair ele = pq.remove();
            if (ele.data.next != null)
                pq.add(new Pair(ele.data.next, ele.listIndex));
            pointer.next = ele.data;
            pointer = pointer.next;
        }
        return head.next;
    }
}
```