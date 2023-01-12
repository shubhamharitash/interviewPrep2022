package searching.binarySearch.theory;

public class Q11_NextGreatestLetter {
    public char nextGreatestLetter(char[] arr, char x) {
        int start = 0;
        int end = arr.length - 1;
        char res = arr[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                res = arr[mid];
                end = mid - 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
