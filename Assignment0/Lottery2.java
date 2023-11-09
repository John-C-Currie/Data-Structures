import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery2 {
    //don't submit this one, this is just as an example
    public static void main(String[] args) {
        List<Integer> winners = new ArrayList<>();
        Random ran = new Random();
        int numDraws = 6;
        int size = 49;
        for (int i = 0; i < numDraws; i++) {
            int randomNum = ran.nextInt(size) + 1;
            while (winners.contains(randomNum)) {
                randomNum = ran.nextInt(size) + 1;
            }
            winners.add(randomNum);
        }

        winners.sort(null);

        System.out.println("The winning numbers are: " + winners);
    }
    
}
