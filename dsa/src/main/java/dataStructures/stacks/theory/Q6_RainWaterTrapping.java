package dataStructures.stacks.theory;

import java.util.Arrays;
import java.util.Stack;

public class Q6_RainWaterTrapping {
    public static int[] nearestGreaterToRight(int[] height) {
        int[] res = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) {
            int lastPopped = -1;
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                lastPopped = stack.pop();
            }
            res[i] = stack.empty() ? lastPopped : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] prefixSum(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] + arr[i];
        }
        return res;
    }

    public static int trap(int[] height) {
        int[] ngr = nearestGreaterToRight(height);
        int[] prefixSumArr = prefixSum(height);
        int i = 0;
        int res = 0;
        while (i < height.length) {
            if (height[i] != 0 && ngr[i] != -1) {
                int length = Math.min(height[i], height[ngr[i]]);
                int width = ngr[i] - i - 1;
                int debrisArea = prefixSumArr[ngr[i] - 1] - prefixSumArr[i];
                res += length * width - debrisArea;
                i = ngr[i];
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Arrays.toString(nearestGreaterToRight(heights)));
        System.out.println(Arrays.toString(Arrays.stream(nearestGreaterToRight(heights)).map(e -> e != -1 ? heights[e] : -1).toArray()));
        System.out.println(trap(heights));
    }
}
