## Problem Statement
https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

## Approaches
#### Approach 1(Recursion)
Here we keep on recurring and making the node visted to keep track of whether that node was earlier visited in dfs or not
Time complexity: O(V+E)

###### Code
```java
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public static boolean[] visited = null;
    public static ArrayList<Integer> helper(int vertex, ArrayList<ArrayList<Integer>> adj){
        if(visited[vertex])
            return new ArrayList<>();
        visited[vertex] = true;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(vertex);
        adj.get(vertex).forEach(e -> {
            res.addAll(helper(e, adj));
        });
        return res;
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        return helper(0, adj);
    }
}
```

#### Usecases

1) Detecting cycle
2) Path Finding
3) Topological sort
4) Testing if graph is bipartite
5) [[Strongly connected components]]
6) Solving mazes

#### Types of Edges
In dfs we encounter given below types of edges
![[DFS(Depth first search)-1678928936071.jpeg]]
![[DFS(Depth first search)-1678930061379.jpeg]]
