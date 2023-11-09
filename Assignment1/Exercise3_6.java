import java.util.ArrayList;
import java.util.List;

public class Exercise3_6
{
    public static List<String> addStars(ArrayList<String> list)
    {
        for(int i = list.size(); i > 0; i--)
        {
            list.add(i,"*");
        }
        return list;
    }

    public static List<String> removeStars(ArrayList<String> list)
    {
        for(int i = list.size() - 1; i > 0; i-=2)
        {
            list.remove(i);
        }
        return list;
    }

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(addStars(list));
        System.out.println(removeStars(list));
    }


}