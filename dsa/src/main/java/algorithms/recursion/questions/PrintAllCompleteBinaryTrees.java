package algorithms.recursion.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PrintAllCompleteBinaryTrees {
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

    public static void main(String[] args) {

    }
}
