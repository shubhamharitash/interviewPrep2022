## Problem Statement
https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

## Approaches
#### Approach 1(BFS)
![[Shortest Path in unweighted graph-1679079107510.jpeg]]
We simply perform bfs and while performing bfs, take care to update distance for unvisited nodes. If a new path is encountered, we check if its better than previous and update accordingly.
Time Complexity:O(V+E)

###### Code
```java
class Solution {
    
    public static int[] helper(int vertices, ArrayList<ArrayList<Integer>> adj, int src){
        int[] shortestDist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(shortestDist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        shortestDist[src] = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(visited[temp])
                continue;
            visited[temp] = true;
            adj.get(temp).forEach(e -> {
                q.offer(e);
                shortestDist[e] = shortestDist[e]==-1 ? shortestDist[temp] + 1:Math.min(shortestDist[e], shortestDist[temp] + 1);
            });
        }
        return shortestDist;
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return helper(n, adj, src);
    }
}
```