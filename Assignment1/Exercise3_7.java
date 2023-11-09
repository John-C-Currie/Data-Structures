import java.util.ArrayList;
import java.util.List;

public class Exercise3_7 {
    // Assume that the lists are sorted
    public static List<Integer> intersect(ArrayList<Integer>list1, ArrayList<Integer>list2)
    {
        List<Integer> list3 = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < list1.size(); i++)
        {
            for(int j = count; j < list2.size(); j++)
            {
                if(list1.get(i) == list2.get(j))
                {
                    list3.add(list1.get(i));
                    count = j;
                    break;
                }
            }
        }
        return list3;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 8));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(2, 4, 6, 7, 8, 10));
        System.out.println(intersect(list1, list2));
    }
    
}
