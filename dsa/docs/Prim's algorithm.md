## Problem Statement
https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

## Approaches
#### Approach 1
Time Complexity: ElogV
Zerox same as [[Shortest Path in weighted graph(Dijikstra)]] We only change the relaxation statement.
Instead of 
`newDist = dist[temp.get(0)] + node.get(1);`
we simply use 
`newDist = node.get(1);`
cause at each point we are only concerned about the edge since all vertices are connected with each other.
![[Prim's algorithm-1679195281984.jpeg]]

###### Code
```java
class Solution{
    public static int helper(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.get(1)));
        ArrayList<Integer> root = new ArrayList<>();
        root.add(0);
        root.add(0);
        dist[0] = 0;
        pq.add(root);
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = pq.remove();
            if(visited[temp.get(0)])
                continue;
            visited[temp.get(0)] = true;
            adj.get(temp.get(0)).forEach(node -> {
                if(!visited[node.get(0)]){
                    int newDist = node.get(1);
                    if(newDist < dist[node.get(0)])
                        dist[node.get(0)] = newDist;
                    ArrayList<Integer> newNode = new ArrayList<>();
                    newNode.add(node.get(0));
                    newNode.add(dist[node.get(0)]);
                    pq.add(newNode);
                }
            });
        }
        return Arrays.stream(dist).sum();
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();   
	    for(int i=0; i<V; i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<edges.length; i++){
	        ArrayList<Integer> temp = new ArrayList<>();
	        temp.add(edges[i][1]);
	        temp.add(edges[i][2]);
	        adj.get(edges[i][0]).add(temp);
	        temp = new ArrayList<>();
	        temp.add(edges[i][0]);
	        temp.add(edges[i][2]);
	        adj.get(edges[i][1]).add(temp);
	    }
	   // System.out.println(adj);
	    return helper(V, adj);
	}
}
```