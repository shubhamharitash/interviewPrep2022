## Problem Statement #ImportantQuestionStack 
https://leetcode.com/problems/remove-duplicate-letters/description/

## Approaches
#### Approach 1
Here we use stack to keep track of elements which can be a part of our solution.
Any element which is greater than current element and its replacement can be found ahead is remove from stack and marked unvisited.
![[Remove Duplicate Letters-1680352837102.jpeg]]

###### Code
```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean[] visited = new boolean[26];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            freq[index]--;
            if(visited[index])
                continue;
            while(!stk.isEmpty() && index<stk.peek() && freq[stk.peek()]!=0){
                visited[stk.pop()] = false;
            }
            visited[index] = true;
            stk.push(index);
        }
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty()){
            res.insert(0, (char)(stk.pop() + 'a'));
        }
        return res.toString();
    }
}
```