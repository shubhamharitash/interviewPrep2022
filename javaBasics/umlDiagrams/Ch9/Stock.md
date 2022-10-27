```mermaid
classDiagram
	class Stock {
		+String symbol
		+String name
		+double previousClosingPrice
		+double currentPrice
		+Stock(symbol, name)
		+getChangePercent()
	}
```
