package algorithms.recursion.questions;

import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferentWaysToAddParentheses {
    public static List<String> operatorsInExpression(String regex, String expression) {
        Pattern pattern = Pattern.compile(regex);
        List<String> operators = new LinkedList<>();
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operators.add(matcher.group());
        }
        return operators;
    }

    public static int evaluate(int value1, int value2, String op) {
        switch (op) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
        }
        return 0;
    }

    public static List<Integer> solve(List<Integer> nums, List<String> operators) {
        if (operators.size() == 1) {
            int v1 = nums.get(0);
            int v2 = nums.get(1);
            String op = operators.get(0);
            List<Integer> res = new ArrayList<>();
            res.add(evaluate(v1, v2, op));
            return res;
        } else if (operators.size() == 0) {
            return new ArrayList<>(nums);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            List<Integer> res1 = new ArrayList<>(solve(nums.subList(0, i + 1), operators.subList(0, i)));
            String op = operators.get(i);
            List<Integer> res2 = new ArrayList<>(solve(nums.subList(i + 1, nums.size()), operators.subList(i + 1, operators.size())));
//            res1.forEach(res1Ele -> {
//                res2.forEach(res2Ele -> {
//                    res.add(evaluate(res1Ele, res2Ele, op));
//                });
//            });
            res.addAll(res1.stream().flatMap(res1Ele -> res2.stream().map(res2Ele -> evaluate(res1Ele, res2Ele, op))).collect(Collectors.toList()));
        }
        return res;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        String regx = "[+\\-*/]";
        List<Integer> nums = Arrays.stream(expression.split(regx))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
        List<String> operators = operatorsInExpression(regx, expression);
        return solve(nums, operators);
    }

    public static void main(String[] args) {
//        String regx = "[+\\-*/]";
//        List<Integer> nums = Arrays.stream("21*33-41*54".split(regx)).map(Integer::valueOf).collect(Collectors.toList());
//
//        Pattern pattern = Pattern.compile(regx);
//        ArrayList<String> list = new ArrayList<>();
//        //Matching the compiled pattern in the String
//        Matcher matcher = pattern.matcher("21*33-41*54/90/34/62");
//        while (matcher.find()) {
//            list.add(matcher.group());
//        }
//        System.out.println(list);
//        System.out.println(IntStream.range(0, 10).boxed().collect(Collectors.toList()).subList(0, 10));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
