## Problem Statement
https://www.geeksforgeeks.org/stock-buy-sell/
Related Problems
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

## Approaches
#### Approach 1(Two Pointer)
#ImpQuestionTwoPointer 
Here we simply keep finding local minima then local maxima 
![[Stock Buy and Sell-1682171815157.jpeg]]

###### Code
```java
class Interval{
    int buy;
    int sell;
}

class Solution {
    public void stockBuySell(int[] price, int n) {
        // code here
        
        if(n<1){
            System.out.println("No Profit");
        }
        ArrayList<Interval> sol=new ArrayList<Interval>();
        int i=0;
        int cnt=0;
        while(i<n-1) {
            
            //local minima
            
            while((i<n-1) && (price[i+1] <=price[i])){
                i++;
            }
            if(i==n-1) {
                break;
            }
            Interval e=new Interval();
            e.buy=i++;
             while((i<n) && (price[i] >=price[i-1])){
                i++;
            }
            e.sell=i-1;
            sol.add(e);
            cnt++;
            
        }
        if(cnt==0){
            System.out.print("No Profit");
        }
        else{
            for(int j=0;j<cnt;j++) {
                System.out.print("("+ sol.get(j).buy + " "+sol.get(j).sell+") ");
            }
        }
         System.out.println();
    }
}
```