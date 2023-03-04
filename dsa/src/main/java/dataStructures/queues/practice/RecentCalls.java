package dataStructures.queues.practice;

import java.util.LinkedList;
import java.util.List;

public class RecentCalls {
    LinkedList<Integer> list;

    public RecentCalls() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        int lowerBound = t - 3000;
        list.addLast(t);
        while (!list.isEmpty() && list.getFirst() < lowerBound) {
            list.removeFirst();
        }
        return list.size();
    }
}
