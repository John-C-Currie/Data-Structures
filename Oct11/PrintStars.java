package Oct11;

public class PrintStars {

    public static void printStars(int n){
        if (n == 0) return;
        System.out.print("* ");
        printStars(n-1);
    }

    public static void main(String[] args) {
        printStars(5);
    }
    
}
