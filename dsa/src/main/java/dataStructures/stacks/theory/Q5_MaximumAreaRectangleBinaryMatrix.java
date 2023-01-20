package dataStructures.stacks.theory;

import java.util.Stack;

public class Q5_MaximumAreaRectangleBinaryMatrix {
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

    public static int largestRectangleArea(int[] heights) {
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

    public static int[] constructHeightsArray(char[][] matrix, int rowSize, int colSize) {
        int[] heights = new int[colSize];
        for (int i = 0; i < heights.length; i++) {
            int val = 0;
            for (int j = rowSize - 1; j >= 0; j--) {
                if (matrix[j][i] == '0')
                    break;
                val++;
            }
            heights[i] = val;
        }
        return heights;
    }

    public static int maximalRectangle(char[][] matrix) {
        int res = 0;
        for (int i = 1; i <= matrix.length; i++) {
            res = Math.max(res, largestRectangleArea(constructHeightsArray(matrix, i, matrix[0].length)));
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(chars));
    }
}
