## Single Dimensional Arrays

#### Initialzing array
```java
double[] myList = {1.9, 2.9, 3.4, 3.5};
```

#### Filling Array with a single value
```java
Arrays.fill(dp, true);
```

#### Four Ways to Copy Arrays

Arrays.copyOf
```
Point[] px = Arrays.copyOf(points, points.length); 
```

###### Loop and copy Individual elements
```java
for(int i=0; i<arr.length; i++){
	dupArr[i] = arr[i]
}
```

###### arraycopy from System class
```java
System.arraycopy(sourceArray, srcPos, targetArray, tarPos, length);
```

###### clone method : details in [[Ch13#clone method]]

#### java.util.Arrays
Consists of useful functions related to Arrays like
- sort
- parallelSort
- fill

#### #ImportantQuestionsArrays 
###### Ch7_Q15_EliminateDuplicates
> Push logic is used to shift -1 to the end of the array



#### Questions
> Q: If high is a very large integer such as the maximum int value 2147483647, (low + high) / 2 may cause overflow. How do you fix it to avoid overflow?
> A:  low + (high-low)/2






