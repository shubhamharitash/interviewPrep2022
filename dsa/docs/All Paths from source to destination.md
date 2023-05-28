## Problem Statement
https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices-1587115620/1

## Approaches
#### Approach 1
![[All Paths from source to destination-1679225802451.jpeg]]

###### Code
```java
class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int helper(int V, ArrayList<ArrayList<Integer>> adj, int src, int dest){
        if(src == dest)
            return 1;
        int res = adj.get(src)
                    .stream()
                    .map(node -> helper(V, adj, node, dest))
                    .reduce(0, (a,b) -> (a+b));
        return res;
    }
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int src,
                   int dest) {
        return helper(V, adj, src, dest);
    }
}
```