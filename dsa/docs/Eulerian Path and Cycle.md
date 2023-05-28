## Problem Statement
https://www.geeksforgeeks.org/eulerian-path-and-circuit/

## Approaches
#### Approach 1
![[Eulerian Path and Cycle-1679505665551.jpeg]]
![[Eulerian Path and Cycle-1679505694403.jpeg]]

###### Code
```java
class Solution
{
    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(visited[src])
            return;
        visited[src] = true;
        adj.get(src).forEach(dest -> {
            dfs(dest, adj, visited);
        });
    }
    public boolean isConnected(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        int i=0;
        // node with non zero degree
        while(adj.get(i).size()==0 && i<V)
            i++;
		// if no node with non zero degree return true
        if(i==V)
            return true;
        dfs(i, adj, visited);
        for(i=0; i<V; i++){
            if(adj.get(i).size()!=0 && !visited[i])
                return false;
        }
        return true;
    }
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        if(!isConnected(V, adj)){
            return 0;
        }
        int cntOddDegree = 0;
        cntOddDegree = adj.stream().map(nodes -> nodes.size()%2).reduce(0, (a,b) -> a+b);
        return cntOddDegree>2? 0
               :cntOddDegree==2? 1:2;
    }
}
```