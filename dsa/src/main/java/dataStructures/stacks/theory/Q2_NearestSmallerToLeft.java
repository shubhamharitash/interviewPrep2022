package dataStructures.stacks.theory;

import java.util.Arrays;
import java.util.Stack;

public class Q2_NearestSmallerToLeft {
    public static long[] nearestSmallerToLeft(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] res = new long[arr.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
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
        System.out.println(Arrays.toString(nearestSmallerToLeft(arr, arr.length)));
    }
}
