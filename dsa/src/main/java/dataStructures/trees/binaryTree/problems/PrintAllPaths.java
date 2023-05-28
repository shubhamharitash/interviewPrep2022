package dataStructures.trees.binaryTree.problems;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class PrintAllPaths {
    public ArrayList<ArrayList<Integer>> Paths(Noder root){
        // Code here
        if(root==null)
            return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> leftPaths= Paths(root.left);
        ArrayList<ArrayList<Integer>> rightPaths= Paths(root.right);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.addAll(leftPaths);
        res.addAll(rightPaths);
        res = (ArrayList<ArrayList<Integer>>) res.stream()
                .map(e -> {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(root.data);
                    temp.addAll(e);
                    return temp;
                })
                .collect(Collectors.toList());
        return res;
    }
}
