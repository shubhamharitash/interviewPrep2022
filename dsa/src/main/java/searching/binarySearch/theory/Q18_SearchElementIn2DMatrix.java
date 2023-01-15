package searching.binarySearch.theory;

public class Q18_SearchElementIn2DMatrix {

    public static int upperBoundRow(int[][] mat, int key){
        int start = 0;
        int end = mat.length -1;
        int res = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mat[mid][mat[0].length-1] < key)
                start = mid + 1;
            else {
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }

    public static int binarySearchCol(int[][] mat, int colIndex, int key){
        int start = 0;
        int end = mat[colIndex].length -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mat[colIndex][mid] == key)
                return mid;
            else if(mat[colIndex][mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    public static boolean searchMatrix(int[][] mat, int target) {
        System.out.println(upperBoundRow(mat, target));
        return binarySearchCol(mat, upperBoundRow(mat, target), target) !=-1 ? true: false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,3}};
        searchMatrix(mat, 2);
    }
}
