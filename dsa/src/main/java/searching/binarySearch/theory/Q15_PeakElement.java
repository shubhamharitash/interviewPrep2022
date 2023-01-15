package searching.binarySearch.theory;

public class Q15_PeakElement {
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean midMinusOneInRange = !((mid - 1) < 0);
            boolean midPlusOneInRange = !((mid + 1) > (arr.length - 1));
            boolean validMidMinusOne = midMinusOneInRange && arr[mid - 1] < arr[mid];
            boolean validMidPlusOne = midPlusOneInRange && arr[mid + 1] < arr[mid];
            boolean validBothMinusAndPlus = validMidMinusOne && validMidPlusOne;
            if (
                    (validBothMinusAndPlus) ||
                    (!midMinusOneInRange && !midPlusOneInRange) ||
                    (!midPlusOneInRange && validMidMinusOne) ||
                    (!midMinusOneInRange && validMidPlusOne)
            ) {
                return mid;
            } else if (midMinusOneInRange && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else if (midPlusOneInRange && arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
