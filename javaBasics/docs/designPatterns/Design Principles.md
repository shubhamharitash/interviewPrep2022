1) Identify the aspects of your application that vary and separate them from what stays the same.
2) Program to an interface, not an implementation.
```mermaid
classDiagram
	class FlyBehaviour {
		void fly()
	}
	<<interface>> FlyBehaviour
	FlyBehaviour <|-- FlyWithWings : implements
	FlyBehaviour <|-- FlyNoWay : implements
	%% implements no flight
	class FlyWithWings{
		void fly()
	}
	%% implements no flight
	class FlyNoWay{
		void fly()
	}
```

3) Favor composition over inheritance.
4) Strive for loosely coupled designs betweenn objects that interact
	1) Why loosely coupled?






