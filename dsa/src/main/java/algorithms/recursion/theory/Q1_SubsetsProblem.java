package algorithms.recursion.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1_SubsetsProblem {
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        int[] smallPart = new int[nums.length - 1];
        System.arraycopy(nums, 1, smallPart, 0, nums.length - 1);
        List<List<Integer>> res = subsets(smallPart);
        int cur_size = res.size();
        for (int i = 0; i < cur_size; i++) {
            List<Integer> temp = new ArrayList<>(res.get(i));
            temp.add(0, nums[0]);
            res.add(temp);
        }
        return res;
    }

    public static void printSubsetsOfStrings(String str, String output) {
        if (str.length() == 0) {
            System.out.println(output);
            return;
        }
        printSubsetsOfStrings(str.length() > 1 ? str.substring(1) : "", output);
        printSubsetsOfStrings(str.length() > 1 ? str.substring(1) : "",  output + str.charAt(0));
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3};
//        System.out.println(subsets(arr));
        printSubsetsOfStrings("abc", "");
    }
}
