package tempTest;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        List<String> temp = new ArrayList<>();
        temp.add("Shubham Sharma");
        temp.add("Prakhar");
        temp.add("Prakhar 1");
        temp.add("Prakhar 2");
        temp.add("Prakhar 3");
        temp.add("Prakhar 4");
        System.out.println(temp);
        temp.remove("Shubham Sharma");
        System.out.println(temp);
    }
}
