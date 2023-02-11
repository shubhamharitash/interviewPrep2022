package codewars;


public class FindOutlier {
    public static int temp(int[] integers) {
        int[] arr = new int[2];
        int countEven = 0;
        for (int integer : integers) {
            arr[(integer % 2 + 2) % 2] = integer;
            if (integer % 2 == 0)
                countEven++;
        }
        return arr[countEven == 1 ? 0 : 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[2];
        System.out.println(temp(new int[]{2, -6, 8, -10, -3}));
    }
}
