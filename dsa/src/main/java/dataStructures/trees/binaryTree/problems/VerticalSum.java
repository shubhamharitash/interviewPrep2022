package dataStructures.trees.binaryTree.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Noder {
    int data;
    Noder left, right;

    Noder(int d) {
        data = d;
        left = right = null;
    }
}



public class VerticalSum {
    public static void helper(Noder root, int col, int[] arr) {
        if (root == null)
            return;
        arr[col] += root.data;
        helper(root.left, col - 1, arr);
        helper(root.right, col + 1, arr);
    }

    public ArrayList<Integer> verticalSum(Noder root) {
        int[] arr = new int[1001];
        helper(root, 500, arr);
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.stream(arr).filter(e -> e != 0).forEach(res::add);
        return res;
    }
}
