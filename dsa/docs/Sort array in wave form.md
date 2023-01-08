[Link](https://www.geeksforgeeks.org/sort-array-wave-form-2/)

## Approaches
#### Approach 1
1) Sort complete array
2) swap(i,i+1) then next pair and so on
3) if i+1 not their it will remain as is
1 2 3 4 5 6 7

(2 1) (4 3) (6 5) 7

#### Code
```java
public static void convertToWave(int n, int[] arr) {
	Arrays.sort(arr);
	for(int i=0;i+1<n;i+=2) {
		arr[i] = arr[i] + arr[i+1];
		arr[i+1] = arr[i] - arr[i+1];
		arr[i] = arr[i] -arr[i+1];
	}
}
```

