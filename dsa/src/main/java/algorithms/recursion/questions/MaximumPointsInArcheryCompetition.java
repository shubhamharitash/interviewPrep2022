package algorithms.recursion.questions;

import java.util.Arrays;

public class MaximumPointsInArcheryCompetition {
    public static int solve(int numArrows, int[] aliceArrows, int[] bobArrows, int index) {
        if (index == aliceArrows.length || numArrows <= 0)
            return 0;
        int choice1 = 0, choice2 = 0;
        if (numArrows > aliceArrows[index]) {
            choice1 = solve(numArrows - aliceArrows[index] - 1, aliceArrows, bobArrows, index + 1) + index;
            choice2 = solve(numArrows, aliceArrows, bobArrows, index + 1);
            bobArrows[index] = choice1 > choice2 ? aliceArrows[index] + 1 : 0;
            return Math.max(choice1, choice2);
        }
        return solve(numArrows, aliceArrows, bobArrows, index + 1);
    }

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bobArrows = new int[aliceArrows.length];
        System.out.println(solve(numArrows, aliceArrows, bobArrows, 0));
        return bobArrows;
    }

    public static void main(String[] args) {
        int[] aliceArrows = {1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(maximumBobPoints(2, aliceArrows)));
    }
}
