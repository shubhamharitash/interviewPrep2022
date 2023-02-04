#### When applicable?
- You need to use existing class but interface doesn't match the one you require.
- You need to use several existing subclasses but its impractical to adapt there features by subclassing every one of them

#### Explanation
[[adapterPattern.pdf]]

#### Stucture
![[Adapter Pattern-1670743374290.jpeg]]

#### Example 
###### Design
```mermaid
classDiagram
	class RoundHole {
		- int radius
		+ RoundHole(int radius)
		+ int getRadius()
		+ boolean fits(RoundPeg roundPeg)
	}
	class RoundPeg {
		- int radius
		+ RoundPeg(int radius)
		+ int getRadius()
	}
	class SquarePegAdapter {
		- SquarePeg squarePeg
		+ SquarePegAdapter(SquarePeg squarePeg)
		+ getRadius()
	}
	RoundPeg <|-- SquarePegAdapter
	SquarePegAdapter o-- SquarePeg
	class SquarePeg {
		- int width
		+ SquarePeg(int width)
		+ int getWidth()
	}
```

###### Implementation Structure
![[Adapter Pattern-1670751316614.jpeg]]

#### Definition
The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

![[Adapter Pattern-1674419345832.jpeg]]



#### Todos
- [x] Find a good example and implement it ✅ 2023-01-23














