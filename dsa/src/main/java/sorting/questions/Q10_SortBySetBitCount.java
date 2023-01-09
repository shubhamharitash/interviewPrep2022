package sorting.questions;

import java.util.Arrays;
import java.util.Comparator;

class CompareBySetBit implements Comparator<Integer> {

    private int countSetBitsEasy(int num) {
        String str = Integer.toBinaryString(num);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    private int countSetBitsUsingLoop(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt = (num & 1) > 0 ? cnt + 1 : cnt;
            num >>= 1;
        }
        return cnt;
    }

    @Override
    public int compare(Integer s1, Integer s2) {
//        return Integer.compare(countSetBitsUsingLoop(s1), countSetBitsUsingLoop(s2));
        return Integer.compare(Integer.bitCount(s1), Integer.bitCount(s2));
    }
}

public class Q10_SortBySetBitCount {
    public static void sortBySetBit(Integer[] arr, int n){
        Arrays.sort(arr, new CompareBySetBit());
    }
    public static void main(String[] args) {
//        System.out.println(countSetBitsUsingLoop(15));
    }
}
