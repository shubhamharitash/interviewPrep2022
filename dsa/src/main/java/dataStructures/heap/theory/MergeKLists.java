package dataStructures.heap.theory;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKLists {
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
