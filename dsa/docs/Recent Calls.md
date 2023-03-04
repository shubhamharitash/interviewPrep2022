## Problem Statement
https://leetcode.com/problems/number-of-recent-calls/description/

## Approaches
#### Approach 1
![[Recent Calls-1676788786489.jpeg]]

###### Code
```java
class RecentCounter {
    LinkedList<Integer> list;

    public RecentCounter() {
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
```