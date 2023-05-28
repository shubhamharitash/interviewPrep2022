## Problem Statement
https://www.geeksforgeeks.org/minimum-halls-required-for-class-scheduling/

## Approaches
#### Approach 1
Here we take help of interval coloring
Create class pair
```java
class pair{
	int first;//time
	int second;//-1 for exit and 1 for entry
}
```

Create and arraylist for time elements where we sort elements by first element
```java
Time.sort(Comparator.comparingInt((pair a) -> a.first));
```

We iterate the list and maintain sum and ans. ans keeps track of highest value of sum and sum keeps track of halls required at a particular time.

###### Code
```java
// Java implementation of the above approach
import java.util.*;

class GFG {
	// Function to return the minimum
	// number of halls required
	static int minHalls(int lectures[][], int n)
	{

		// Initialize a vector of pair, Time, first value
		// indicates the time of entry or exit of a lecture
		// second value denotes whether the lecture starts
		// or ends
		ArrayList<pair> Time = new ArrayList<>();

		// Store the lecture times
		for (int i = 0; i < n; i++) {
			Time.add(new pair(lectures[i][0], 1));
			Time.add(new pair(lectures[i][1], -1));
		}

		// Sort the vector
		Collections.sort(Time, (pair A, pair B) -> {
			return A.first - B.first;
		});

		int answer = 0, sum = 0;

		// Traverse the Time vector and Update sum and
		// answer variables
		for (int i = 0; i < Time.size(); i++) {
			sum += Time.get(i).second;
			answer = Math.max(answer, sum);
		}

		// Return the answer
		return answer;
	}

	static class pair {
		int first, second;
		pair(int x, int y)
		{
			first = x;
			second = y;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int lectures[][]
			= { { 0, 5 }, { 1, 2 }, { 1, 10 } };
		int n = lectures.length;

		System.out.println(minHalls(lectures, n));
	}
}

```