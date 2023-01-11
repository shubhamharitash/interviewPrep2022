package leetcodeBasicQuestions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        return IntStream
                .range(1, n + 1)
                .mapToObj(e -> {
                    if (e % 3 == 0 && e % 5 == 0)
                        return "FizzBuzz";
                    else if (e % 3 == 0) {
                        return "Fizz";
                    } else if (e % 5 == 0) {
                        return "Buzz";
                    }
                    return String.valueOf(e);
                })
                .collect(Collectors.toList());
    }
}
