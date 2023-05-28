## Problem Statement
https://www.geeksforgeeks.org/strongly-connected-components/

## Approaches
#### Approach 1(Kosaraju's Algorithm)
Time Complexity: O(V+E)
![[Strongly connected components-1679240847982.jpeg]]

###### Code
```java
class Solution
{
    boolean[] visited;
    Stack<Integer> stk;
    public ArrayList<ArrayList<Integer>> transpose(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> transposedAdj = new ArrayList<>();
        for(int i=0; i<V; i++){
            transposedAdj.add(new ArrayList<>());
        }
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i=0; i<V; i++){
            int root = i;
            adj.get(root).forEach(node -> {
               ArrayList<Integer> edge = new ArrayList<>();
               edge.add(node);
               edge.add(root);
               edges.add(edge);
            });
        }
        for(int i=0; i<edges.size(); i++){
            transposedAdj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        return transposedAdj;
    }
    
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj,int src){
        if(visited[src])
            return;
        visited[src] = true;
        adj.get(src).forEach(node -> {
            dfs(V, adj, node);
        });
        stk.push(src);
    } 
    
    public void dfsWithoutStk(int V, ArrayList<ArrayList<Integer>> adj,int src){
        if(visited[src])
            return;
        visited[src] = true;
        adj.get(src).forEach(node -> {
            dfsWithoutStk(V, adj, node);
        });
    } 
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        visited = new boolean[V];
        stk = new Stack<>();
        for(int i=0; i<V; i++){
            if(!visited[i])
                dfs(V, adj, i);
        }
        adj = transpose(V, adj);
        visited = new boolean[V];
        int cnt = 0;
        while(!stk.isEmpty()){
            int src = stk.pop();
            if(visited[src])
                continue;
            dfsWithoutStk(V, adj, src);
            cnt++;
        }
        return cnt;
    }
}
```
