## Resources
https://www.digitalocean.com/community/tutorials/java-8-stream
https://www.baeldung.com/java-when-to-use-parallel-stream
https://stackoverflow.com/questions/21219667/stream-and-lazy-evaluation

## Simple Use

#### stream
```java
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
listOfNumbers.stream().forEach(number ->
    System.out.println(number + " " + Thread.currentThread().getName())
);
```

#### parallelStream
```java
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
listOfNumbers.parallelStream().forEach(number ->
    System.out.println(number + " " + Thread.currentThread().getName())
);
```

## Splitting Source
Wrong
```java
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum); // Dangerous since each thread will have 5, when result will be joined it will be added as number of times as threads are their
assertThat(sum).isNotEqualTo(15);
```

Right
```java
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4); int sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5; assertThat(sum).isEqualTo(15);
```

## Using custom threadpool
```java
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
ForkJoinPool customThreadPool = new ForkJoinPool(4);
int sum = customThreadPool.submit(
    () -> listOfNumbers.parallelStream().reduce(0, Integer::sum)).get();
customThreadPool.shutdown();
assertThat(sum).isEqualTo(10);
```

## File Search Example
```java
Files.walk(Paths.get("src/main/resources/")).map(Path::normalize).filter(Files::isRegularFile)
      .filter(path -> path.getFileName().toString().endsWith(".txt")).collect(Collectors.toList());
Files.walk(Paths.get("src/main/resources/")).parallel().map(Path::normalize).filter(Files::
      isRegularFile).filter(path -> path.getFileName().toString().endsWith(".txt")).
      collect(Collectors.toList());
```

## Collections and Java Streams
Since we can use primitive data types such as int, long in the collections using auto-boxing and these operations could take a lot of time, there are specific classes for primitive types - `IntStream`, `LongStream` and `DoubleStream`.

## Functions and BiFunctions
![[Java Stream API for Bulk Data Operations on Collections-1673164310761.jpeg]]

## Predicate and BiPredicate
![[Java Stream API for Bulk Data Operations on Collections-1673164370321.jpeg]]

## Consumer and BiConsumer
![[Java Stream API for Bulk Data Operations on Collections-1673164451476.jpeg]]

## Supplier
![[Java Stream API for Bulk Data Operations on Collections-1673164488898.jpeg]]