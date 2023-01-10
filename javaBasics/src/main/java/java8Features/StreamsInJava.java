package java8Features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Track {
    String name;
    int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}

public class StreamsInJava {
    public static void main(String[] args) {
        // Using filter logic and collect
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        System.out.println(integerList.stream().filter(e -> e % 2 ==0).collect(Collectors.toList()));

        // Using IntStream
        List<Long> longList = IntStream.range(0,10).mapToLong(e -> e*100L).boxed().collect(Collectors.toList());

        // Using map
        System.out.println(longList.stream().map(Long::doubleValue).collect(Collectors.toList()));

        // Using flatMap
        List<Integer> streamOfListToList = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> {
                    return numbers.stream().map(e -> e*e);
                })
                .collect(Collectors.toList());
        System.out.println(streamOfListToList);

        // max and min
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        System.out.println(tracks.stream().sorted(Comparator.comparing(Track::getLength)).collect(Collectors.toList()));
        System.out.println(tracks.stream().min(Comparator.comparing(Track::getLength)).get());
        System.out.println(tracks.stream().max(Comparator.comparing(Track::getLength)).get());
            // It returns an optional
        System.out.println((new ArrayList<Track>()).stream().max(Comparator.comparing(Track::getLength)).isPresent());

        // reduce
        // max value using reduce
        System.out.println(Stream.of(1,2,3,5,-1,-4).reduce(Integer.MIN_VALUE, (maxValue, b) -> maxValue > b ? maxValue: b));
        // sum using reduce
        System.out.println(Stream.of(1,2,3,5,-1,-4).reduce(0, (acc, element) -> acc + element));
    }
}
