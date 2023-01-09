[Link]((https://www.geeksforgeeks.org/sort-array-according-count-set-bits/)

## Approaches
#### Approach 1
Using bitcount -> it returns count of bits in $O(1)$
```java
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
```

#### Approach 2
Using loop
Complexity: $O(log(n))$
```java
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
	    return Integer.compare(countSetBitsUsingLoop(s1), countSetBitsUsingLoop(s2)); 
    }  
}
```