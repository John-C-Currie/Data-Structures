import java.util.Arrays;

public class Lottery {
    public static void main(String[] args) {
        int size = 49;
        int numDraws = 6;
        int[] numbers = new int[size];
        for (int i = 1; i <= size; i++)
        {
            numbers[i-1] = i;
        }

        int[] winningNumbers = new int[numDraws];

        for (int i = 0; i < numDraws; i++)
        {
            int randomIndex = (int) (Math.random() * (size - i));
            winningNumbers[i] = numbers[randomIndex];
            numbers[randomIndex] = numbers[size - i - 1];
        }

        Arrays.sort(winningNumbers);
        System.out.println("The winning numbers are: " + Arrays.toString(winningNumbers));
    }
}
