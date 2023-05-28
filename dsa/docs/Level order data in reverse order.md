## Problem Statement
https://www.geeksforgeeks.org/reverse-level-order-traversal/

## Approaches
#### Approach 1
![[Level order data in reverse order-1678043164538.jpeg]]

###### Code
```java
public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        Stack<Node> stk = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        stk.push(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right!=null){
                queue.offer(temp.right);
                stk.push(temp.right);
            }
            if(temp.left!=null){
                queue.offer(temp.left);
                stk.push(temp.left);
            }
        }
        while(!stk.isEmpty()){
            res.add(stk.pop().data);
        }
        return res;
    }
```