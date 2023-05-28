**Approach 1(recursive)**
Simply perform DLR

**Code**
```java
static ArrayList<Integer> preorder(Node root)
{
	if(root == null){
		return new ArrayList<Integer>();
	}
	int data = root.data;
	ArrayList<Integer> res = new ArrayList<>();
	res.add(data);
	res.addAll(preorder(root.left));
	res.addAll(preorder(root.right));
	return res;
}
```

**Approach 2(iterative)**
Using Two Stacks
![[Binary Tree-1678001853878.jpeg]]

**Code**
```java
static ArrayList<Integer> preorder(Node root)
{
	ArrayList<Integer> res = new ArrayList<>();
	Stack<Node> stk1 = new Stack<>();
	Stack<Node> stk2 = new Stack<>();
	stk1.push(root);
	while(!stk1.isEmpty() || !stk2.isEmpty()){
		Node temp = !stk1.isEmpty() ? stk1.pop():stk2.pop();
		res.add(temp.data);
		if(temp.left!=null)
			stk1.push(temp.left);
		if(temp.right!=null)
			stk2.push(temp.right);
	}
	return res;
}
```

**Approach 3(iterative)**
Using one stack
![[Binary Tree-1678001835137.jpeg]]

**Code**
```java
static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> stk1 = new Stack<>();
        Node temp = root;
        while(temp!=null){
            res.add(temp.data);
            if(temp.right!=null)
                stk1.push(temp.right);
            temp = temp.left!=null ? temp.left: !stk1.isEmpty() ? stk1.pop():null;
        }
        return res;
    }
```
