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

#### Todos
- [ ] Find a good example and implement it














