## Problem Statement
Compute next greatest letter

## Approaches
#### Approach 1
Same as [[Ceil of an element in sorted array]]

###### Code
```java
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
```

