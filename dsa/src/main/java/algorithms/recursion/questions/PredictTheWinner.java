package algorithms.recursion.questions;

public class PredictTheWinner {
    public static boolean PredictTheWinnerMethod(int[] nums) {
        return winner(nums, 0, nums.length - 1, 1) >= 0;
    }
    public static int winner(int[] nums, int s, int e, int turn) {
        if (s == e)
            return turn * nums[s];
        int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }

    public static void main(String[] args) {
        int[] arr = {3606449, 6, 5, 9, 452429, 7, 9580316, 9857582, 8514433, 9, 6, 6614512, 753594, 5474165, 4, 2697293, 8, 7, 1};
        PredictTheWinnerMethod(arr);
    }
}
