![[Pasted image 20230109203328.png]
![[Streams-1673276734554.jpeg]]

#### Map
![[Streams-1673277539038.jpeg]]

#### [What is a Boxed Stream](https://howtodoinjava.com/java8/java8-boxed-intstream/)
![[Streams-1673278044055.jpeg]]

#### Filter
![[Streams-1673278450208.jpeg]]

#### FlatMap
![[Streams-1673278569185.jpeg]]
Basically it can convert `Stream<List<T>>` --> `Stream<T>`

#### Min and Max

#### sorting
Easiest Way to sort a collection
```java
System.out.println(tracks.stream().sorted(Comparator.comparing(Track::getLength)).collect(Collectors.toList()));
```

#### Reduce
https://www.baeldung.com/java-stream-reduce
![[Streams-1673280768037.jpeg]]
![[Streams-1673282003164.jpeg]]
```java
System.out.println(Stream.of(1,2,3,5,-1,-4).reduce(Integer.MIN_VALUE, (maxValue, b) -> maxValue > b ? maxValue: b));
```

#### Putting everything together
![[Streams-1673282139644.jpeg]]


#### Refactoring Legacy Code
>Sample Leacy Code
![[Streams-1673315313325.jpeg]]

>Refactored Java Code
```java
Set<String> trackNames = albums
						.stream()
						.flatMap(album -> album.getTracks())
						.filter(track -> track.length()>60)
						.map(track -> track.getName())
						.collect(Collectors.toSet())
```

#### Remember
![[Streams-1673315822798.jpeg]]
DON'T DO THIS ❌

![[Streams-1673315853242.jpeg]]
DO THIS ✅️

#### Higher Order Functions
If a functional interface is used as a parameter or return type, you have a higher-order function.