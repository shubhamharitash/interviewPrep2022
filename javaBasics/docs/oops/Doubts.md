```java
List<Integer> numbers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
```
> How does above logic work?

```java
List<Integer> ints = Files.lines(Paths.get("src/main/resources/sorting/input.txt"))  
        .map(Integer::parseInt)  
        .collect(Collectors.toList());
```
> Explore this java 8 feature

Todos
- [ ] resolve doubts