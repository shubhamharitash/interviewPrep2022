## Problem Statement
https://leetcode.com/problems/different-ways-to-add-parentheses/description/

## Approaches
#### Approach 1
![[Different Ways to Add Parentheses-1675366599020.jpeg]]

###### Code(Simple and Easy)
```java
public List<Integer> diffWaysToCompute(String input) {  
    List<Integer> ret = new LinkedList<Integer>();  
    for (int i = 0; i < input.length(); i++) {  
        if (input.charAt(i) == '-' ||  
                input.charAt(i) == '*' ||  
                input.charAt(i) == '+') {  
            String part1 = input.substring(0, i);  
            String part2 = input.substring(i + 1);  
            List<Integer> part1Ret = diffWaysToCompute(part1);  
            List<Integer> part2Ret = diffWaysToCompute(part2);  
            for (Integer p1 : part1Ret) {  
                for (Integer p2 : part2Ret) {  
                    int c = 0;  
                    switch (input.charAt(i)) {  
                        case '+':  
                            c = p1 + p2;  
                            break;  
                        case '-':  
                            c = p1 - p2;  
                            break;  
                        case '*':  
                            c = p1 * p2;  
                            break;  
                    }  
                    ret.add(c);  
                }  
            }  
        }  
    }  
    if (ret.size() == 0) {  
        ret.add(Integer.valueOf(input));  
    }  
    return ret;  
}
```

#### Code(Difficult)(MyWay)
```java
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
```