**Approach 1(Recursive)**
Simply Apply LDR

**Code**
```java
ArrayList<Integer> inOrder(Node root) {
	if(root == null){
		return new ArrayList<Integer>();
	}
	int data = root.data;
	ArrayList<Integer> res = new ArrayList<>();
	res.addAll(inOrder(root.left));
	res.add(data);
	res.addAll(inOrder(root.right));
	return res;
}
```

**Approach 2(Iterative)**
We use a variable and stack to maintain which element to process
cur == null is the indication that all left elements have been added so print the top of stack and set cur = its right child.
![[Inorder-1678010544670.jpeg]]

**Code**
```java
ArrayList<Integer> inOrder(Node root) {
	ArrayList<Integer> res = new ArrayList<>();
	Node cur = root;
	Stack<Node> stk = new Stack<>();
	while(cur!=null || !stk.isEmpty()){
		if(cur!=null){
			stk.push(cur);
			cur = cur.left;
		} else {
			Node temp = stk.pop();
			res.add(temp.data);
			cur = temp.right;
		}
	}
	return res;
}
```