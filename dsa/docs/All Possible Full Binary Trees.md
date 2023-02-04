## Problem Statement
https://leetcode.com/problems/all-possible-full-binary-trees/description/

## Approaches
#### Approach 1
Simple recursion
![[All Possible Full Binary Trees-1675350110343.jpeg]]

###### Code
```java
public List<TreeNode> allPossibleFBT(int n) {  
    if (n == 1) {  
        TreeNode node = new TreeNode(0);  
        List<TreeNode> res = new ArrayList<>();  
        res.add(node);  
        return res;  
    }  
    List<TreeNode> res = new ArrayList<>();  
    for (int i = 1; i <= n - 2; i++) {  
        int finalI = i;  
        res.addAll(  
                allPossibleFBT(i)  
                        .stream()  
                        .flatMap(leftTree -> allPossibleFBT(n - finalI - 1)  
                                .stream()  
                                .map(rightTree -> new TreeNode(0, leftTree, rightTree))  
                        )  
                        .collect(Collectors.toList())  
        );  
    }  
    return res;  
}
```

