package Classwork;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("one", "two", "three", "four"));
        System.out.println(list);
        System.out.println(list.size());
        
        for(int i = list.size() - 1; i > 0; i--)
        {
            list.add(i,"+");
        }
        System.out.println(list);

    }
}
