package sorting;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratingFileToSort {
    public static void main(String[] args) {
        try (
                PrintWriter fileOutput = new PrintWriter(Paths.get("src/main/resources/sorting/input.txt").toFile())
        ) {
            List<Integer> range = IntStream.range(0, 100000000).boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            Collections.shuffle(range);
            range.forEach(fileOutput::println);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
