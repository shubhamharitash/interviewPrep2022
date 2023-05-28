## Problem Statement
https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1(Recursive)
Simple recursion

###### Code
```java
class Tree
{
	public static int getSize(Node root)
	{
        if(root==null)
            return 0;
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
```