package searching.binarySearch.theory;

import java.util.Arrays;

public class Q19_AllocatePagesOfBooks {
    public static boolean isPossible(int[] arr, int targetValue, int k) {
        int curSum = 0;
        int studentsReq = 1;
        for (int j : arr) {
            if (j > targetValue)
                return false;
            if (curSum + j > targetValue) {
                studentsReq++;
                curSum = j;
                if (studentsReq > k)
                    return false;
            } else
                curSum += j;
        }
        return true;
    }

    public static int solve(int[] arr, int k) {
        if (k > arr.length)
            return -1;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int res = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, mid, k)) {
                res = Math.min(res, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 19, 10, 5, 18, 7};
        int k = 5;
        System.out.println(solve(arr, k));
    }
}
