package dataStructures.trees.binaryTree.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAncestors {
    public static ArrayList<Integer> helper(Noder root, int target){
        if(root==null)
            return new ArrayList<>();
        if(root.data==target){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(target);
            return temp;
        }
        ArrayList<Integer> leftPath = helper(root.left, target);
        ArrayList<Integer> rightPath = helper(root.right, target);
        if(leftPath.size()!=0){
            leftPath.add(root.data);
            return leftPath;
        }
        if(rightPath.size()!=0){
            rightPath.add(root.data);
            return rightPath;
        }
        return new ArrayList<>();
    }
    public static ArrayList<Integer> Ancestors(Noder root, int target)
    {
        // add your code here
        ArrayList<Integer> temp = helper(root, target);
        ArrayList<Integer> res = new ArrayList<>();
        if(temp.size()>1){
            res.addAll(temp.subList(1, temp.size()));
        }
        return res;
    }
}
