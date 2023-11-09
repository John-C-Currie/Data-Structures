package Oct11;

public class RecursiveArraySum {
    
    public static int sum(int[] list){
        return sum(list, 0);
    }

    private static int sum(int[] list, int index){
        if (index == list.length) return 0;
        return list[index] + sum(list, index+1);
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        int[] list0 = {0};
        System.out.println(sum(list));
        System.out.println(sum(list0));
    }
    
}
