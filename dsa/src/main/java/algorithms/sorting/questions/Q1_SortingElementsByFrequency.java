package algorithms.sorting.questions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Q1_SortingElementsByFrequency {
    public static void main(String[] args) {
        try (
                Scanner input = new Scanner(Paths.get("src/main/resources/questions/input.txt").toFile());
                PrintWriter output = new PrintWriter(Paths.get("src/main/resources/questions/output.txt").toFile());
        ) {
            // Create hashmap with frequency
            Map<Integer, Integer> countMap = new HashMap<>();
            while (input.hasNextInt()) {
                int inputInteger = input.nextInt();
                if (!countMap.containsKey(inputInteger)) {
                    countMap.put(inputInteger, 1);
                } else {
                    countMap.put(inputInteger, countMap.get(inputInteger) + 1);
                }
            }

            // Create the list from map
            List<Map.Entry<Integer, Integer>> temp = countMap
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing( e -> -e.getValue()))
                    .collect(Collectors.toList());
            // output
            temp.forEach(
                    e -> {
                        for (int i = 0; i < e.getValue(); i++) {
                            output.print(e.getKey() + " ");
                        }
                    }
            );
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
