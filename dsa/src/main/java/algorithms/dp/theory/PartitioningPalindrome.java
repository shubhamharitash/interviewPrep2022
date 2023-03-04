package algorithms.dp.theory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningPalindrome {
    public List<List<String>> solve(String s, int i, int j){
        if(i==j){
            List<List<String>> res = new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add(s.substring(i, j+1));
            res.add(list);
            return res;
        }
        String revStr = (new StringBuilder(s)).reverse().toString();
        List<List<String>> res = new ArrayList<>();
        if(revStr.equals(s)){
            List<String> list1 = new ArrayList<>();
            list1.add(s);
            res.add(list1);
        }
        for (int k = i; k < j; k++) {
            List<List<String>> ans1 = solve(s, i, k);
            List<List<String>> ans2 = solve(s, k+1, j);
            Set<List<String>> list = ans1.stream()
                                    .flatMap(ans1Ele -> ans2.stream()
                                                        .map(ans2Ele -> {
                                                            List<String> temp = new ArrayList<>(ans1Ele);
                                                            temp.addAll(ans2Ele);
                                                            return temp;
                                                        })
                                    ).collect(Collectors.toSet());
            res.addAll(new ArrayList<>(list));
        }
        return res;
    }
    public List<List<String>> partition(String s) {
        return solve(s, 0, s.length()-1);
    }
}
