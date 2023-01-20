package dataStructures.stacks.theory;

import java.util.Arrays;
import java.util.Stack;

public class Q2_Variation_NearestSmallerToRight {
    public static long[] nearestSmallerToRight(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] res = new long[arr.length];
        Arrays.fill(res, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            res[i] = !stack.empty() ? arr[stack.peek()] : -1;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = new long[]{7, 8, 1, 4};
        System.out.println(Arrays.toString(nearestSmallerToRight(arr, arr.length)));
    }
}
