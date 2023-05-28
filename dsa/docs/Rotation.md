We perform single or double rotations according to given below 4 scenarios when `balacingFactor(T)==2`

#### Single Rotations
###### LL
![[Rotation-1678611405281.jpeg]]
![[Rotation-1678611424895.jpeg]]

```java
public static Node singleRotateLL(Node root){
	Node p = root;
	Node q = root.left;
	p.left = q.right;
	q.right = p;
	p.height = heightMax(p.left, p.right) + 1;
	q.height = heightMax(q.left, q.right) + 1;
	return q;
}
```

###### RR
![[Rotation-1678611484347.jpeg]]
![[Rotation-1678611513170.jpeg]]

```java
public static Node singleRotateRR(Node root){
	Node p = root;
	Node q = root.right;
	p.right = q.left;
	q.left = p;
	p.height = heightMax(p.left, p.right) + 1;
	q.height = heightMax(q.left, q.right) + 1;
	return q;
}
```

#### Double Rotations
###### LR
![[Rotation-1678611600366.jpeg]]

```java
public static Node doubleRotateLR(Node root){
	root.left = singleRotateRR(root.left);
	return singleRotateLL(root);
}
```

###### RL
![[Rotation-1678611714795.jpeg]]

```java
public static Node doubleRotateRL(Node root){
	root.right = singleRotateLL(root.right);
	return singleRotateRR(root);
}
```