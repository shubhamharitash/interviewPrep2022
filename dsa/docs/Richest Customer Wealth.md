```java
public class MaximumHealth {  
    public static int maximumWealth(int[][] accounts) {  
        return Arrays.stream(accounts).map(e -> Arrays.stream(e).reduce(0, Integer::sum)).max(Comparator.naturalOrder()).get();  
    }  
  
    public static void main(String[] args) {  
        int[][] accounts = new int[][]{{1,2,3},{3,2,1}};  
        System.out.println(maximumWealth(accounts));  
    }  
}
```