## Problem Statement
https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

## Approaches
#### Approach 1
![[Activity Selection-1679757881072.jpeg]]

###### Code
```java
class Activity{
    int start;
    int end;
    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        PriorityQueue<Activity> pq = new PriorityQueue<>(Comparator.comparingInt((Activity e) -> e.end));
        for(int i=0; i<n; i++){
            pq.offer(new Activity(start[i], end[i]));
        }
        Activity node = pq.poll();
        int cnt = 1;
        while(!pq.isEmpty()){
            Activity temp = pq.poll();
            if(node.end>=temp.start)
                continue;
            cnt++;
            node = temp;
        }
        return cnt;
    }
}
```