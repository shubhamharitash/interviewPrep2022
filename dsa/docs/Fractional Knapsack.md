## Problem Statement
https://www.geeksforgeeks.org/fractional-knapsack-problem/

## Approaches
#### Approach 1
Here we simply pick the most valuable item on basis of value/weight ratio.

###### Code
```java
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingDouble((Item e) -> -((double)e.value/e.weight)));
        Arrays.stream(arr).forEach(e -> {
           pq.offer(e); 
        });
        double maxValue = 0;
        while(!pq.isEmpty() && W>0){
            Item item = pq.poll();
            if(W>=item.weight){
                maxValue += item.value;
                W -= item.weight;
            } else {
                maxValue += (double)(item.value*W)/(double)item.weight;
                W=0;
            }
        }
        return maxValue;
    }
}
```