**Approach 1(Recursive)**
Simply Apply LRD

**Code**
```java
ArrayList<Integer> postOrder(Node root)
{
   // Your code goes here
	if(root == null){
		return new ArrayList<Integer>();
	}
	int data = root.data;
	ArrayList<Integer> res = new ArrayList<>();
	res.addAll(postOrder(root.left));
	res.addAll(postOrder(root.right));
	res.add(data);
	return res;
}
```

**Approach 2(Iterative)**
https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
Here we can't simply traverse since for a parent with both left and right child, we would have no way of knowing if both left and right are traversed or not.
To overcome that we push right node and root, traverse to left for all such nodes.

![[Postorder-1678013745988.jpeg]]

when cur == null
	we compare top's right child with next top. If they are same then we perform reversal.
	else we print top and set cur as null

**Code**
```java
ArrayList<Integer> postOrder(Node root)
{
   // Your code goes here
	ArrayList<Integer> res = new ArrayList<>();
	Stack<Node> stk = new Stack<>();
	Node cur = root;
	while(cur!=null || !stk.isEmpty()){
		if(cur!=null){
			if(cur.right!=null)
				stk.push(cur.right);
			stk.push(cur);
			cur = cur.left;
		} else {
			Node temp = stk.pop();
			if(!stk.isEmpty() && temp.right == stk.peek()){
				cur = stk.pop();
				stk.push(temp);
			} else {
				res.add(temp.data);
				cur = null;
			}
		}
	}
	return res;
}
```