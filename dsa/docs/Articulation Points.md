## Problem Statement
https://cp-algorithms.com/graph/cutpoints.html#implementation

## Approaches
#### Approach 1(Tarjan's Algorithm)
![[Articulation Points-1679418191083.jpeg]]
![[Articulation Points-1679418214791.jpeg]]
![[Articulation Points-1679418239868.jpeg]]

###### Code
```java
class Solution
{
    boolean[] visited;
    int[] low;
    int[] tin;
    int[] articulationArr;
    int timer = 0;
    //Function to return Breadth First Traversal of given graph.
    public void dfs(int v, int parent, ArrayList<ArrayList<Integer>> adj){
        visited[v] = true;
        low[v] = tin[v] = timer++;
        int children = 0;
        for(int i=0; i<adj.get(v).size(); i++){
            int to = adj.get(v).get(i);
            if(visited[to]){
                low[v] = Math.min(low[v], tin[to]);
            } else {
                dfs(to, v, adj);
                low[v] = Math.min(low[v], low[to]);
                if(low[to]>=tin[v] && parent!=-1)
                    articulationArr[v] = v;
                children++;
            }
        }
        if(parent==-1 && children > 1){
            articulationArr[v] = v;
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        visited = new boolean[V];
        articulationArr = new int[V];
        low = new int[V];
        tin = new int[V];
        Arrays.fill(articulationArr, -1);
        for(int i=0; i<V; i++){
            if(!visited[i])
                dfs(i, -1, adj);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(articulationArr[i]!=-1)
                res.add(articulationArr[i]);
        }
        if(res.isEmpty())
            res.add(-1);
        return res;
    }
}
```