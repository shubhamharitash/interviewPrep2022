package dataStructures.stacks.theory;

import java.util.Arrays;
import java.util.Stack;

public class Q4_MaximumAreaOfHistogram {
    public static int[] nearestSmallerToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            res[i] = !stack.empty() ? stack.peek() : -1;
            stack.push(i);
        }
        return res;
    }

    public static int[] nearestSmallerToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            res[i] = !stack.empty() ? stack.peek() : n;
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nsl = nearestSmallerToLeft(heights, heights.length);
        int[] nsr = nearestSmallerToRight(heights, heights.length);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int length = nsr[i] - nsl[i] - 1;
            int width = heights[i];
            res = Math.max(res, length * width);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
