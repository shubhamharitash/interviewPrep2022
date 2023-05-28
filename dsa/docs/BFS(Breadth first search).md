## Problem Statement
https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

## Approaches
#### Approach 1(Using Queue)
We visit vertices in level order fashion taking care if the node had been visited earlier or not.

###### Code
```java
public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
	Queue<Integer> q = new LinkedList<>();
	q.offer(0);
	ArrayList<Integer> res = new ArrayList<>();
	boolean[] visited = new boolean[V];
	while(!q.isEmpty()){
		int temp = q.poll();
		if(!visited[temp]){
			adj.get(temp).forEach(q::offer);
			visited[temp] = true;
			res.add(temp);
		}
	}
	return res;
}
```

#### Usecases
1) Finding all connected components in graph
2) Finding all nodes within one connected component
3) Finding shortest path between two nodes
4) Testing graph for bipartiteness

