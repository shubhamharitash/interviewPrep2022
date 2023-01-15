## Problem Statement
Search and element in a 2D matrix which is sorted both row-wise and column-wise
Approach 1: When next row elements are greater than previous row elements
Approach 2: When next row elements are not greater than previous row elements

## Approaches
#### Approach 1(This approach works for leetcode problem since next row elements are greater than previous row elements)
1) Upper bound on `mat[m-1][0...n]` column to determine row index
2) binary search on `mat[0...m][index]` 

**Complexity: $O(log(m) + log(n))$**

###### Code
```java
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
```

#### Approach 2(For gfg problem)
1) start with top right corner
2) go left if `arr[i][j] < key`
3) go down if `arr[i][j] > key`
4) return if out of bound or value found

###### Code
```java
static boolean search(int mat[][], int m, int n, int key) 
{  
	int i = m-1;
	int j = 0;
	while(i >= 0 && j<n){
		if(mat[i][j] == key){
			return true;
		} else if(mat[i][j] < key) {
			j++;
		} else {
			i--;
		}
	}
	return false;
} 
```
