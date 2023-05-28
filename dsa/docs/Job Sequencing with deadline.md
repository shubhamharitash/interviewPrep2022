## Problem Statement
https://www.geeksforgeeks.org/job-sequencing-problem/

## Approaches
#### Approach 1
1) pick elements from priority queue in order of maximum profit
2) check for greatestTimeSlot available
	1) If available the add the job profit
	2) else ignore and move ahead.

###### Code
```java
public int greatestTimeSlotAvailable(boolean[] time, int i){
	while(i!=-1){
		if(!time[i]){
			return i;
		}
		i--;
	}
	return -1;
}
int[] JobScheduling(Job arr[], int n)
{
	PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt((Job e) -> -e.profit));
	boolean[] time = new boolean[Arrays.stream(arr).mapToInt((Job e) -> e.deadline).reduce(Integer.MIN_VALUE, Integer::max)];
	int[] res = new int[2];
	Arrays.stream(arr).forEach(pq::offer);
	while(!pq.isEmpty()){
		Job job = pq.poll();
		int timeSlot = greatestTimeSlotAvailable(time, job.deadline-1);
		if(timeSlot!=-1){
			res[0]++;
			res[1]+=job.profit;
			time[timeSlot] = true;
		}
	}
	return res;
}
```