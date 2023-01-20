package dataStructures.stacks.theory;

import java.util.Arrays;
import java.util.Stack;

public class Q1_NearestGreaterToRight {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] res = new long[arr.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (stack.empty() || arr[stack.peek()] >= arr[i]) {
                stack.push(i);
            } else {
                while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                    res[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static long[] nextLargerElementApproach2(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] res = new long[arr.length];
        Arrays.fill(res, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = !stack.empty() ? arr[stack.peek()] : -1;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = new long[]{7, 8, 1, 4};
        System.out.println(Arrays.toString(nextLargerElementApproach2(arr, arr.length)));
    }
}
