package dataStructures.stacks.theory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Q3_StockSpanProblem {
    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.empty() || !stack.empty() && price[stack.peek()] > price[i]) {
                res[i] = 1;
            } else {
                int lastPopped = -1;
                while (!stack.empty() && price[stack.peek()] <= price[i]) {
                    lastPopped = stack.pop();
                }
                res[i] = lastPopped == -1 ? i : res[lastPopped] + i - lastPopped;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] calculateSpanV2(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = i - (stack.empty() ? 0 : stack.peek());
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(calculateSpanV2(arr, arr.length)));
    }
}
