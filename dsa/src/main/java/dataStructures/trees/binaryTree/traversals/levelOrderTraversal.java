package dataStructures.trees.binaryTree.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class levelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            res.add(temp.data);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
