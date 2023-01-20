## Problem Statement
Print all possible subsets for a given input string.

## Approaches
#### Approach 1(Using Recursion)
For leetcode one
![[Subset Problem-1674059130038.jpeg]]

![[Subset Problem-1674062396087.jpeg]]

###### Code
```java
public static List<List<Integer>> subsets(int[] nums) {  
    if (nums.length == 0) {  
        List<List<Integer>> res = new ArrayList<>();  
        res.add(new ArrayList<>());  
        return res;  
    }  
    int[] smallPart = new int[nums.length - 1];  
    System.arraycopy(nums, 1, smallPart, 0, nums.length - 1);  
    List<List<Integer>> res = subsets(smallPart);  
    int cur_size = res.size();  
    for (int i = 0; i < cur_size; i++) {  
        List<Integer> temp = new ArrayList<>(res.get(i));  
        temp.add(0, nums[0]);  
        res.add(temp);  
    }  
    return res;  
}
```

```java
public static void printSubsetsOfStrings(String str, String output) {  
    if (str.length() == 0) {  
        System.out.println(output);  
        return;  
    }  
    printSubsetsOfStrings(str.length() > 1 ? str.substring(1) : "", output);  
    printSubsetsOfStrings(str.length() > 1 ? str.substring(1) : "",  output + str.charAt(0));  
}
```

#### Approach 2(Using Bit Approach)
1) Find length of string
2) iterate till 2^length of string and print element at set bit

```java
public List<String> AllPossibleStrings(String str)
    {
        // Code here
        int length  = str.length();
        List<String> res = new ArrayList<>();
        for(int i=0; i < (1<<length); i++){
            String s = "";
            for(int j=0;j<length;j++){
                // System.out.println(j);
                // System.out.println(i & (1<<j));
                if((i & (1<<j)) != 0)
                    s+=str.charAt(j);
            }
            res.add(s);
        }
        return res;
    }
```